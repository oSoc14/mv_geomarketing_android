package osoc14.okfn.geomarketing.database;

/**
 * Created by Samuel on 02/07/14.
 */
public class StoreItem {

    public String id;
    public String name;
    public String address;
    public String summary;
    public int resourceIdPicture;
    public boolean following;


    public StoreItem(String id, String name, String address, String summary, int resourceIdPicture, boolean following) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.summary = summary;
        this.resourceIdPicture = resourceIdPicture;
        this.following = following;
    }
}
