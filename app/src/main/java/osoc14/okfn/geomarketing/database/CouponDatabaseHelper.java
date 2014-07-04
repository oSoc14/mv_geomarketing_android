package osoc14.okfn.geomarketing.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuel on 03/07/14.
 */
public class CouponDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "coupontable.db";
    private static final int DATABASE_VERSION = 1;


    public CouponDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        CouponTable.onCreate(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        CouponTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }
}
