package osoc14.okfn.geomarketing.contentprovider;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Samuel on 08/07/14.
 */
public class CouponData {
    public final static String TABLE_NAME = "coupon";
    public final static String TABLE_PREFIX = "cntst";
    public final static String TABLE_PREFIXED_NAME = TABLE_NAME + " " + TABLE_PREFIX;

    public static final String COLUMN__ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SUMMARY = "summary";
    public static final String COLUMN_STORE = "store";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_IMAGE_RES = "image_res";
    public static final String COLUMN_QR_CODE = "qr_code";
    public static final String COLUMN_POINTS = "points";
    public static final String COLUMN_IMAGE_MARKER_U = "image_marker_u";
    public static final String COLUMN_IMAGE_MARKER_S = "image_marker_s";
    public static final String COLUMN_LAT = "lat";
    public static final String COLUMN_LNG = "lng";
    public static final String COLUMN_FAV = "fav";



    // Database creation SQL statement
    private final static String DATABASE_CREATE = "create table if not exists " + TABLE_NAME
            + "("
            + COLUMN__ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text, "
            + COLUMN_SUMMARY + " text, "
            + COLUMN_STORE + " text, "
            + COLUMN_CATEGORY + " text, "
            + COLUMN_IMAGE_RES + " integer, "
            + COLUMN_QR_CODE + " text, "
            + COLUMN_POINTS + " integer, "
            + COLUMN_IMAGE_MARKER_U + " integer, "
            + COLUMN_IMAGE_MARKER_S + " integer, "
            + COLUMN_LAT + " double, "
            + COLUMN_LNG + " double, "
            + COLUMN_FAV + " integer"
            + ");";


    public static void onCreate(final SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }


}
