package osoc14.okfn.geomarketing.model;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;

import osoc14.okfn.geomarketing.contentprovider.CouponData;

/**
 * Created by Samuel on 08/07/14.
 */
public class Coupon {

    int id;
    String name;
    String summary;
    String store;
    String category;
    int imageRes;
    int imageMarker_u; // unselected
    int imageMarker_s; // selected
    //int imageMarker_f; // favorited
    String qrCode;
    int points;
    double lat;
    double lng;



    public Coupon() {
    }

    public Coupon(String name, String summary, String store, String category, int imageRes, String qrCode, int points, int imageMarker_s, int imageMarker_u, double lat, double lng) {
        this.name = name;
        this.summary = summary;
        this.store = store;
        this.category = category;
        this.imageRes = imageRes;
        this.qrCode = qrCode;
        this.points = points;
        this.imageMarker_s = imageMarker_s;
        this.imageMarker_u = imageMarker_u;
        this.lat = lat;
        this.lng = lng;

    }

    public ContentValues getContentValues(){
        ContentValues v = new ContentValues();

        v.put(CouponData.COLUMN_NAME, name);
        v.put(CouponData.COLUMN_SUMMARY, summary);
        v.put(CouponData.COLUMN_STORE, store);
        v.put(CouponData.COLUMN_CATEGORY, category);
        v.put(CouponData.COLUMN_IMAGE_RES, imageRes);
        v.put(CouponData.COLUMN_QR_CODE, qrCode);
        v.put(CouponData.COLUMN_POINTS, points);
        v.put(CouponData.COLUMN_IMAGE_MARKER_S, imageMarker_s);
        v.put(CouponData.COLUMN_IMAGE_MARKER_U, imageMarker_u);
        v.put(CouponData.COLUMN_LAT, lat);
        v.put(CouponData.COLUMN_LNG, lng);

        return v;
    }

    public static Coupon getCoupon(Cursor c) {

        Coupon coupon = new Coupon();
        c.moveToFirst();
        String name = c.getString(c.getColumnIndex(CouponData.COLUMN_NAME));
        String summary = c.getString(c.getColumnIndex(CouponData.COLUMN_SUMMARY));
        String store = c.getString(c.getColumnIndex(CouponData.COLUMN_STORE));
        String category = c.getString(c.getColumnIndex(CouponData.COLUMN_CATEGORY));
        int imageRes = c.getInt(c.getColumnIndex(CouponData.COLUMN_IMAGE_RES));
        int imageMarker_u = c.getInt(c.getColumnIndex(CouponData.COLUMN_IMAGE_MARKER_U));
        int imageMarker_s = c.getInt(c.getColumnIndex(CouponData.COLUMN_IMAGE_MARKER_S));
        String qrCode = c.getString(c.getColumnIndex(CouponData.COLUMN_QR_CODE));
        int points = c.getInt(c.getColumnIndex(CouponData.COLUMN_POINTS));
        double lat = c.getDouble(c.getColumnIndex(CouponData.COLUMN_LAT));
        double lng = c.getDouble(c.getColumnIndex(CouponData.COLUMN_LNG));

        return new Coupon(name, summary, store, category, imageRes, qrCode, points, imageMarker_s, imageMarker_u, lat, lng);
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getStore() {
        return store;
    }

    public String getCategory() {
        return category;
    }

    public int getImageRes() {
        return imageRes;
    }

    public int getImageMarker_u() {
        return imageMarker_u;
    }

    public int getImageMarker_s() {
        return imageMarker_s;
    }

    public String getQrCode() {
        return qrCode;
    }

    public int getPoints() {
        return points;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}