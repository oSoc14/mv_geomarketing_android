package osoc14.okfn.geomarketing;

import android.app.Application;
import android.content.Context;

import osoc14.okfn.geomarketing.finaldatabase.Category;
import osoc14.okfn.geomarketing.finaldatabase.MyDatabaseHelper;

/**
 * Created by Samuel on 05/07/14.
 */
public class MyApp extends Application {

    private static MyApp myApp;

    public static MyApp getInstance() {
        return  myApp;
    }

    private static Context c;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        c = getBaseContext();
        db = new MyDatabaseHelper(c);
    }

    public static boolean loggedIn = false;
    public static String username = "Samuel";
    public static int currentCategory = 6;
    public static Category currentCategoryFull;
    public static MyDatabaseHelper db;



}
