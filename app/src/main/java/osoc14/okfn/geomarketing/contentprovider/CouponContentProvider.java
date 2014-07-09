package osoc14.okfn.geomarketing.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Samuel on 08/07/14.
 */
public class CouponContentProvider extends ContentProvider{
    public static final String PROVIDER_NAME = "osoc14.okfn.geomarketing.contentprovider.CouponContentProvider";

    public static final Uri CONTENT_URI_ALL_COUPONS = Uri.parse("content://" + PROVIDER_NAME);
    public static final Uri CONTENT_URI_ONE_COUPON = Uri.parse("content://" + PROVIDER_NAME + "/id");

    public static final Uri CONTENT_URI_ALL_FRIENDS = Uri.parse("content://" + PROVIDER_NAME + "/friends");
    public static final Uri CONTENT_URI_ONE_FRIENDS = Uri.parse("content://" + PROVIDER_NAME + "/friends/id");

    public static final Uri CONTENT_URI_ALL_ACTIVITIES = Uri.parse("content://" + PROVIDER_NAME + "/activities");

    public static final Uri CONTENT_URI_ALL_REQUESTS = Uri.parse("content://" + PROVIDER_NAME + "/requests");

    public static final Uri CONTENT_URI_COUPONS_BY_CATEGORY = Uri.parse("content://" + PROVIDER_NAME + "/category/id");


    private static final int TYPE_ALL_COUPONS = 1;
    private static final int TYPE_ONE_COUPON = 2;

    private static final int TYPE_ALL_FRIENDS = 3;
    private static final int TYPE_ONE_FRIENDS = 4;

    private static final int TYPE_ALL_ACTIVITIES = 5;

    private static final int TYPE_ALL_REQUESTS = 6;

    private static final int TYPE_ALL_COUPONS_BY_CATEGORY = 7;

    private static final UriMatcher uriMatcher;
    static
    {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(PROVIDER_NAME, null, TYPE_ALL_COUPONS);
        uriMatcher.addURI(PROVIDER_NAME, "id/*", TYPE_ONE_COUPON);
        uriMatcher.addURI(PROVIDER_NAME, "friends", TYPE_ALL_FRIENDS);
        uriMatcher.addURI(PROVIDER_NAME, "friends/id/*", TYPE_ONE_FRIENDS);
        uriMatcher.addURI(PROVIDER_NAME, "activities", TYPE_ALL_ACTIVITIES);
        uriMatcher.addURI(PROVIDER_NAME, "requests", TYPE_ALL_REQUESTS);
        uriMatcher.addURI(PROVIDER_NAME, "category/id/*", TYPE_ALL_COUPONS_BY_CATEGORY);

    }

    private MyDatabaseHelper databaseHelper;
    private SQLiteDatabase database;


    public CouponContentProvider() {
    }

    @Override
    public boolean onCreate()
    {
        this.databaseHelper = new MyDatabaseHelper(this.getContext());
        this.database = this.databaseHelper.getWritableDatabase();
        return true;

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri))
        {
            case TYPE_ALL_COUPONS:
            case TYPE_ONE_COUPON:
                return "vnd.android.cursor.dir/" + PROVIDER_NAME;

            default:

                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        switch (uriMatcher.match(uri))
        {
            case TYPE_ALL_COUPONS:

                this.database.insert(CouponData.TABLE_NAME, null, values);
                this.getContext().getContentResolver().notifyChange(uri, null);
                return uri;

            case TYPE_ALL_FRIENDS:
                this.database.insert(FriendsData.TABLE_NAME, null, values);
                this.getContext().getContentResolver().notifyChange(uri, null);
                return uri;

            case TYPE_ALL_ACTIVITIES:
                this.database.insert(ActivityData.TABLE_NAME, null, values);
                this.getContext().getContentResolver().notifyChange(uri, null);
                return uri;

            case TYPE_ALL_REQUESTS:
                this.database.insert(RequestData.TABLE_NAME, null, values);
                this.getContext().getContentResolver().notifyChange(uri, null);
                return uri;

            default:

                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

    }



    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        final int match = uriMatcher.match(uri) ;
        String id;

        String tableName;

        switch (match)
        {
            case TYPE_ALL_COUPONS:
                tableName = CouponData.TABLE_NAME;
                break;
            case TYPE_ALL_FRIENDS:
                tableName = FriendsData.TABLE_NAME;
                break;

            case TYPE_ONE_COUPON:
                tableName = CouponData.TABLE_NAME;
                id = uri.getLastPathSegment();
                selection = CouponData.COLUMN__ID + "=?";
                selectionArgs =  new String[]{id};
                break;

            case TYPE_ALL_COUPONS_BY_CATEGORY:
                tableName = CouponData.TABLE_NAME;
                id = uri.getLastPathSegment();
                selection = CouponData.COLUMN_CATEGORY + "=?";
                selectionArgs =  new String[]{id};
                break;

            case TYPE_ONE_FRIENDS:
                tableName = FriendsData.TABLE_NAME;
                id = uri.getLastPathSegment();
                selection = FriendsData.COLUMN__ID + "=?";
                selectionArgs = new String[]{id};
                break;

            case TYPE_ALL_ACTIVITIES:
                tableName = ActivityData.TABLE_NAME;
                break;

            case TYPE_ALL_REQUESTS:
                tableName = RequestData.TABLE_NAME;
                break;

            default:
                return null;
        }

        final Cursor cursor = this.database.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(this.getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}