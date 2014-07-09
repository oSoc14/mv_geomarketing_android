package osoc14.okfn.geomarketing.model;

import android.content.ContentProvider;
import android.content.ContentValues;

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
    String qrCode;


    public Coupon() {
    }

    public Coupon(String name, String summary, String store, String category, int imageRes, String qrCode) {
        this.name = name;
        this.summary = summary;
        this.store = store;
        this.category = category;
        this.imageRes = imageRes;
        this.qrCode = qrCode;
    }

    public ContentValues getContentValues(){
        ContentValues v = new ContentValues();

        v.put(CouponData.COLUMN_NAME, name);
        v.put(CouponData.COLUMN_SUMMARY, summary);
        v.put(CouponData.COLUMN_STORE, store);
        v.put(CouponData.COLUMN_CATEGORY, category);
        v.put(CouponData.COLUMN_IMAGE_RES, imageRes);
        v.put(CouponData.COLUMN_QR_CODE, qrCode);

        return v;
    }
}