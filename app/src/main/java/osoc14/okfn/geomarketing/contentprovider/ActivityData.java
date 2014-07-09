package osoc14.okfn.geomarketing.contentprovider;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Samuel on 09/07/14.
 */
public class ActivityData {
    public final static String TABLE_NAME = "activity";
    public final static String TABLE_PREFIX = "cntst";
    public final static String TABLE_PREFIXED_NAME = TABLE_NAME + " " + TABLE_PREFIX;

    public static final String COLUMN__ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_IMAGE_RES = "image_res";
    public static final String COLUMN_STORE = "store";


    // Database creation SQL statement
    private final static String DATABASE_CREATE = "create table if not exists " + TABLE_NAME
            + "("
            + COLUMN__ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text, "
            + COLUMN_USERNAME + " text, "
            + COLUMN_SCORE + " integer, "
            + COLUMN_IMAGE_RES + " integer, "
            + COLUMN_STORE + " text "
            + ");";


    public static void onCreate(final SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }
}
