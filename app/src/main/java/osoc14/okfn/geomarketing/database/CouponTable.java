package osoc14.okfn.geomarketing.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Samuel on 03/07/14.
 */
public class CouponTable {

    public static final String TABLE_COUPON = "coupon";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "category";
    public static final String COLUMN_DESCRIPTION = "description";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_COUPON
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null, "
            + COLUMN_DESCRIPTION + " text not null"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(CouponTable.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_COUPON);
        onCreate(database);
    }

}
