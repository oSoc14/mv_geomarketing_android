package osoc14.okfn.geomarketing.finaldatabase;

/**
 * Created by Samuel on 06/07/14.
 */
public class Store {

    public static final String TABLE_STORE = "store";
    public static final String KEY_ID = "store_id";
    public static final String KEY_NAME = "store_name";
    public static final String KEY_SUMMARY = "store_summary";
    public static final String KEY_LAT = "store_lat";
    public static final String KEY_LNG = "store_lng";

    public static final String CREATE_STORES =
            "CREATE TABLE " + TABLE_STORE +
                    "(" +
                    KEY_ID + " INTEGER PRIMARY KEY," +
                    KEY_NAME + " TEXT," +
                    KEY_SUMMARY + " TEXT," +
                    KEY_LAT + " DOUBLE," +
                    KEY_LNG + " DOUBLE" +
                    ")";

    long id;
    String name;
    String summary;
    double lat;
    double lng;

    public Store() {
    }

    public Store(String name, String summary, double lat, double lng) {
        this.name = name;
        this.summary = summary;
        this.lat = lat;
        this.lng = lng;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
