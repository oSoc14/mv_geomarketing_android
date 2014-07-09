package osoc14.okfn.geomarketing.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuel on 08/07/14.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{

    private static int dbVersion = 16;
    private static String dbName = "SkoebidoeDatabase";

    private SQLiteDatabase db;

    public MyDatabaseHelper(Context context)
    {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        CouponData.onCreate(db);
        FriendsData.onCreate(db);
        ActivityData.onCreate(db);
        RequestData.onCreate(db);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        CouponData.onUpgrade(db, oldVersion, newVersion);
        FriendsData.onUpgrade(db, oldVersion, newVersion);
        ActivityData.onUpgrade(db, oldVersion, newVersion);
        RequestData.onUpgrade(db, oldVersion, newVersion);

    }
}
