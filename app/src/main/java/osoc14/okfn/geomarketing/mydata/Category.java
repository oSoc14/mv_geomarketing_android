package osoc14.okfn.geomarketing.mydata;

/**
 * Created by Samuel on 06/07/14.
 */
public class Category {

    int id;
    String tag_name;

    // constructors
    public Category() {

    }

    public Category(String tag_name) {
        this.tag_name = tag_name;
    }

    public Category(int id, String tag_name) {
        this.id = id;
        this.tag_name = tag_name;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setTagName(String tag_name) {
        this.tag_name = tag_name;
    }

    // getter
    public int getId() {
        return this.id;
    }

    public String getTagName() {
        return this.tag_name;
    }
}
