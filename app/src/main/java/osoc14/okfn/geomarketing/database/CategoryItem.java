package osoc14.okfn.geomarketing.database;

/**
 * Created by Samuel on 03/07/14.
 */
public class CategoryItem {

    public String id;
    public String title;
    public int resourceIdPicture;

    public CategoryItem(String id, String title, int resourceIdPicture) {
        this.id = id;
        this.title = title;
        this.resourceIdPicture = resourceIdPicture;
    }
}
