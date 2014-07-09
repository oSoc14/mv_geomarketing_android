package osoc14.okfn.geomarketing.finaldatabase;

/**
 * Created by Samuel on 06/07/14.
 */
public class Coupon {


    public static final String TABLE_COUPON = "coupon";
    public static final String KEY_ID = "coupon_id";
    public static final String KEY_NAME = "coupon_name";
    public static final String KEY_SUMMARY = "coupon_summary";
    public static final String KEY_STORE_ID = "coupon_store_id";
    public static final String KEY_CATEGORY_ID = "coupon_category_id";
    public static final String KEY_IMAGE_URI = "coupon_image_uri";
    public static final String KEY_QR_CODE = "coupon_qr_code";

    public static final String CREATE_COUPONS =
            "CREATE TABLE " + TABLE_COUPON +
                    "(" +
                        KEY_ID + " INTEGER PRIMARY KEY," +
                        KEY_NAME + " TEXT," +
                        KEY_SUMMARY + " TEXT," +
                        KEY_STORE_ID + " INTEGER," +
                        KEY_CATEGORY_ID + " INTEGER," +
                        KEY_IMAGE_URI + " TEXT," +
                        KEY_QR_CODE + " TEXT " +
                    ")";

    long id;
    String name;
    String summary;
    long store_id;
    long category_id;
    String imageUri;
    String qrCode;

    String storeName;

    public Coupon() {
    }

    public Coupon(String name, String summary, long store_id, long category_id ,String imageUri, String qrCode) {
        this.name = name;
        this.summary = summary;
        this.store_id = store_id;
        this.imageUri = imageUri;
        this.qrCode = qrCode;
        this.category_id = category_id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
