package osoc14.okfn.geomarketing.database;

/**
 * Created by Samuel on 02/07/14.
 */
public class CouponItem {

    public String id;
    public String title;
    public String store;
    public String summary;
    public int distance;
    public int resourceIdPicture;


    public CouponItem(String id, String title, String store, String summary, int resourceIdPicture, int distance) {
        this.id = id;
        this.title = title;
        this.store = store;
        this.summary = summary;
        this.resourceIdPicture = resourceIdPicture;
        this.distance = distance;
    }

}
