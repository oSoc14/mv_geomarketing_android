package osoc14.okfn.geomarketing.finaldatabase;

/**
 * Created by Samuel on 06/07/14.
 */
public class Category {

    public static final String TABLE_CATEGORY = "category";
    public static final String KEY_ID = "category_id";
    public static final String KEY_NAME = "category_name";

    public static final String CREATE_CATEGORYS =
            "CREATE TABLE " + TABLE_CATEGORY +
                    "(" +
                    KEY_ID + " INTEGER PRIMARY KEY," +
                    KEY_NAME + " TEXT" +
                    ")";


    int id;
    String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String tag) {
        this.name = tag;
    }
}
