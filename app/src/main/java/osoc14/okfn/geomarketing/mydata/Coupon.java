package osoc14.okfn.geomarketing.mydata;

/**
 * Created by Samuel on 06/07/14.
 */
public class Coupon {

    int id;
    String name;
    String summary;
    String store;
    int distance;
    String imageUri;
    String qrCode;
    String created_at;

    public Coupon() {
    }

    public Coupon(String name, String summary, String imageUri, String store, int distance, String qrCode) {
        this.name = name;
        this.summary = summary;
        this.imageUri = imageUri;
        this.qrCode = qrCode;
        this.distance = distance;
    }

    public Coupon(int id, String name, String summary, String imageUri, String store, int distance, String qrCode) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.imageUri = imageUri;
        this.qrCode = qrCode;
        this.distance = distance;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

}
