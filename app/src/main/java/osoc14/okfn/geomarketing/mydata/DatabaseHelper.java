package osoc14.okfn.geomarketing.mydata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Samuel on 06/07/14.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Table Names
    private static final String TABLE_COUPON = "coupon";
    private static final String TABLE_STORE = "store";
    private static final String TABLE_COUPON_STORE = "coupon_store";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // NOTES Table - column nmaes
    private static final String KEY_NAME = "coupon";
    private static final String KEY_SUMMARY = "status";

    // TAGS Table - column names
    private static final String KEY_TAG_NAME = "tag_name";

    // NOTE_TAGS Table - column names
    private static final String KEY_COUPON_ID = "coupon_id";
    private static final String KEY_STORE_ID = "tag_id";

    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_TODO = "CREATE TABLE "
            + TABLE_COUPON + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_SUMMARY + " INTEGER," + KEY_CREATED_AT
            + " DATETIME" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_STORE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TAG_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // todo_tag table create statement
    private static final String CREATE_TABLE_TODO_TAG = "CREATE TABLE "
            + TABLE_COUPON_STORE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_COUPON_ID + " INTEGER," + KEY_STORE_ID + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_TODO);
        db.execSQL(CREATE_TABLE_TAG);
        db.execSQL(CREATE_TABLE_TODO_TAG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUPON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STORE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUPON_STORE);

        // create new tables
        onCreate(db);
    }

    // ------------------------ "todos" table methods ----------------//

    /**
     * Creating a todo
     */
    public long createToDo(Coupon coupon, long[] tag_ids) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, coupon.getName());
        values.put(KEY_SUMMARY, coupon.getSummary());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long todo_id = db.insert(TABLE_COUPON, null, values);

        // insert tag_ids
        for (long tag_id : tag_ids) {
            createTodoTag(todo_id, tag_id);
        }

        return todo_id;
    }

    /**
     * get single todo
     */
    public Coupon getTodo(long todo_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_COUPON + " WHERE "
                + KEY_ID + " = " + todo_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Coupon td = new Coupon();
        td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        td.setName((c.getString(c.getColumnIndex(KEY_NAME))));
        td.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

        return td;
    }

    /**
     * getting all todos
     * */
    public List<Coupon> getAllToDos() {
        List<Coupon> coupons = new ArrayList<Coupon>();
        String selectQuery = "SELECT  * FROM " + TABLE_COUPON;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Coupon td = new Coupon();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setName((c.getString(c.getColumnIndex(KEY_NAME))));
                td.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // adding to todo list
                coupons.add(td);
            } while (c.moveToNext());
        }

        return coupons;
    }

    /**
     * getting all todos under single tag
     * */
    public List<Coupon> getAllToDosByTag(String tag_name) {
        List<Coupon> coupons = new ArrayList<Coupon>();

        String selectQuery = "SELECT  * FROM " + TABLE_COUPON + " td, "
                + TABLE_STORE + " tg, " + TABLE_COUPON_STORE + " tt WHERE tg."
                + KEY_TAG_NAME + " = '" + tag_name + "'" + " AND tg." + KEY_ID
                + " = " + "tt." + KEY_STORE_ID + " AND td." + KEY_ID + " = "
                + "tt." + KEY_COUPON_ID;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Coupon td = new Coupon();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setName((c.getString(c.getColumnIndex(KEY_NAME))));
                td.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // adding to todo list
                coupons.add(td);
            } while (c.moveToNext());
        }

        return coupons;
    }

    /**
     * getting todo count
     */
    public int getToDoCount() {
        String countQuery = "SELECT  * FROM " + TABLE_COUPON;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /**
     * Updating a todo
     */
    public int updateToDo(Coupon coupon) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, coupon.getName());
        values.put(KEY_SUMMARY, coupon.getSummary());

        // updating row
        return db.update(TABLE_COUPON, values, KEY_ID + " = ?",
                new String[] { String.valueOf(coupon.getId()) });
    }

    /**
     * Deleting a todo
     */
    public void deleteToDo(long tado_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COUPON, KEY_ID + " = ?",
                new String[] { String.valueOf(tado_id) });
    }

    // ------------------------ "tags" table methods ----------------//

    /**
     * Creating tag
     */
    public long createTag(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TAG_NAME, category.getTagName());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long tag_id = db.insert(TABLE_STORE, null, values);

        return tag_id;
    }

    /**
     * getting all tags
     * */
    public List<Category> getAllTags() {
        List<Category> categories = new ArrayList<Category>();
        String selectQuery = "SELECT  * FROM " + TABLE_STORE;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Category t = new Category();
                t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                t.setTagName(c.getString(c.getColumnIndex(KEY_TAG_NAME)));

                // adding to tags list
                categories.add(t);
            } while (c.moveToNext());
        }
        return categories;
    }

    /**
     * Updating a tag
     */
    public int updateTag(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TAG_NAME, category.getTagName());

        // updating row
        return db.update(TABLE_STORE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(category.getId()) });
    }

    /**
     * Deleting a tag
     */
    public void deleteTag(Category category, boolean should_delete_all_tag_todos) {
        SQLiteDatabase db = this.getWritableDatabase();

        // before deleting tag
        // check if todos under this tag should also be deleted
        if (should_delete_all_tag_todos) {
            // get all todos under this tag
            List<Coupon> allTagToDos = getAllToDosByTag(category.getTagName());

            // delete all todos
            for (Coupon coupon : allTagToDos) {
                // delete todo
                deleteToDo(coupon.getId());
            }
        }

        // now delete the tag
        db.delete(TABLE_STORE, KEY_ID + " = ?",
                new String[] { String.valueOf(category.getId()) });
    }

    // ------------------------ "todo_tags" table methods ----------------//

    /**
     * Creating todo_tag
     */
    public long createTodoTag(long todo_id, long tag_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COUPON_ID, todo_id);
        values.put(KEY_STORE_ID, tag_id);
        values.put(KEY_CREATED_AT, getDateTime());

        long id = db.insert(TABLE_COUPON_STORE, null, values);

        return id;
    }

    /**
     * Updating a todo tag
     */
    public int updateNoteTag(long id, long tag_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STORE_ID, tag_id);

        // updating row
        return db.update(TABLE_COUPON, values, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    /**
     * Deleting a todo tag
     */
    public void deleteToDoTag(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COUPON, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    /**
     * get datetime
     * */
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
