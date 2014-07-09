package osoc14.okfn.geomarketing.finaldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 06/07/14.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "kuponDummyData";

    private SQLiteDatabase dbRead;// = this.getReadableDatabase();



    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Coupon.CREATE_COUPONS);
        db.execSQL(Category.CREATE_CATEGORYS);
        db.execSQL(Store.CREATE_STORES);

        dbRead = this.getReadableDatabase();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Coupon.TABLE_COUPON);
        db.execSQL("DROP TABLE IF EXISTS " + Category.TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + Store.TABLE_STORE);

        // create new tables
        onCreate(db);
    }

    public long createCoupon(Coupon coupon ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Coupon.KEY_ID, coupon.getId());
        values.put(Coupon.KEY_NAME, coupon.getName());
        values.put(Coupon.KEY_SUMMARY, coupon.getSummary());
        values.put(Coupon.KEY_STORE_ID, coupon.getStore_id());
        values.put(Coupon.KEY_CATEGORY_ID, coupon.getCategory_id());
        values.put(Coupon.KEY_IMAGE_URI, coupon.getImageUri());
        values.put(Coupon.KEY_QR_CODE, coupon.getQrCode());


        // insert row
        long coupon_id = db.insert(Coupon.TABLE_COUPON, null, values);

        return coupon_id;
    }

    public long createCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Category.KEY_ID, category.getId());
        values.put(Category.KEY_NAME, category.getName());

        long category_id = db.insert(Category.TABLE_CATEGORY, null, values);
        return category_id;
    }

    public long createStore (Store store) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Store.KEY_ID, store.getId());
        values.put(Store.KEY_NAME, store.getName());
        values.put(Store.KEY_SUMMARY, store.getSummary());
        values.put(Store.KEY_LAT, store.getLat());
        values.put(Store.KEY_LNG, store.getLng());

        long store_id = db.insert(Store.TABLE_STORE, null, values);
        return store_id;

    }

    public List<Coupon> getAllCouponsByCategory(long category_id) {
        List<Coupon> coupons = new ArrayList<Coupon>();
        String selectQuery = "SELECT  * FROM " + Coupon.TABLE_COUPON + " WHERE " + Coupon.KEY_CATEGORY_ID + " = " + category_id ;

        //SQLiteDatabase db = this.getReadableDatabase();

        if (dbRead == null) {
            dbRead = this.getReadableDatabase();

        }
        Cursor c = dbRead.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Coupon td = new Coupon();
                td.setId(c.getInt((c.getColumnIndex(Coupon.KEY_ID))));
                td.setName((c.getString(c.getColumnIndex(Coupon.KEY_NAME))));
                td.setSummary(c.getString(c.getColumnIndex(Coupon.KEY_SUMMARY)));
                td.setStore_id(c.getInt(c.getColumnIndex(Coupon.KEY_STORE_ID)));
                td.setCategory_id(c.getInt(c.getColumnIndex(Coupon.KEY_CATEGORY_ID)));
                td.setImageUri(c.getString(c.getColumnIndex(Coupon.KEY_IMAGE_URI)));
                td.setQrCode(c.getString(c.getColumnIndex(Coupon.KEY_QR_CODE)));


                coupons.add(td);

            } while (c.moveToNext());
        }
        c.close();
        dbRead.close();


        return coupons;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        String selectQuery = "SELECT * FROM " + Category.TABLE_CATEGORY;

        //SQLiteDatabase db = this.getReadableDatabase();
        if (dbRead == null ){
            dbRead = this.getReadableDatabase();
        }
        Cursor c = dbRead.rawQuery( selectQuery , null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Category td = new Category();
                td.setId(c.getInt((c.getColumnIndex(Category.KEY_ID))));
                td.setName((c.getString(c.getColumnIndex(Category.KEY_NAME))));
                categories.add(td);

            } while (c.moveToNext());
        }

        c.close();
        dbRead.close();

        return categories;


    }

    public Coupon getCoupon( long coupon_id) {

        String selectQuery = "SELECT * FROM " + Coupon.TABLE_COUPON + " WHERE " + Coupon.KEY_ID + " = " + coupon_id ;
        SQLiteDatabase dbRead = this.getReadableDatabase();
        Cursor c = dbRead.rawQuery(selectQuery, null);


        if (c != null) {
            c.moveToFirst();
            Coupon td = new Coupon();
            td.setId(c.getLong((c.getColumnIndex(Coupon.KEY_ID))));
            td.setName((c.getString(c.getColumnIndex(Coupon.KEY_NAME))));
            td.setSummary(c.getString(c.getColumnIndex(Coupon.KEY_SUMMARY)));
            td.setStore_id(c.getInt(c.getColumnIndex(Coupon.KEY_STORE_ID)));
            td.setCategory_id(c.getInt(c.getColumnIndex(Coupon.KEY_CATEGORY_ID)));
            td.setImageUri(c.getString(c.getColumnIndex(Coupon.KEY_IMAGE_URI)));
            td.setQrCode(c.getString(c.getColumnIndex(Coupon.KEY_QR_CODE)));

            return td;
        }

        dbRead.close();
        c.close();


        return null;

    }

    public Store getStore( long store_id ) {

        String selectQuery = "SELECT * FROM " + Store.TABLE_STORE + " WHERE " + Store.KEY_ID + " = " + store_id ;
        SQLiteDatabase dbRead = this.getReadableDatabase();
        Cursor c = dbRead.rawQuery(selectQuery, null);

        if (c != null) {
            c.moveToFirst();
            Store td = new Store();
            td.setId( c.getLong((c.getColumnIndex(Store.KEY_ID))));
            td.setName((c.getString(c.getColumnIndex(Store.KEY_NAME))));
            td.setSummary(c.getString(c.getColumnIndex(Store.KEY_SUMMARY)));
            td.setLat(c.getDouble(c.getColumnIndex(Store.KEY_LAT)));
            td.setLng(c.getDouble(c.getColumnIndex(Store.KEY_LNG)));

            return td;
        }
        return null;
    }
}
