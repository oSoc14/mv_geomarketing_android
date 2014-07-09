package osoc14.okfn.geomarketing.model;

import android.content.ContentValues;

import osoc14.okfn.geomarketing.contentprovider.ActivityData;
import osoc14.okfn.geomarketing.contentprovider.RequestData;

/**
 * Created by Samuel on 09/07/14.
 */
public class Request {

    int id;
    String name;
    String username;
    String store;
    int score;
    double distance;
    int imageRes;

    public Request() {
    }

    public Request(String name, String username, String store, int score, double distance, int imageRes) {
        this.name = name;
        this.username = username;
        this.store = store;
        this.score = score;
        this.distance = distance;
        this.imageRes = imageRes;
    }

    public ContentValues getContentValues(){
        ContentValues v = new ContentValues();

        v.put(RequestData.COLUMN_NAME, name);
        v.put(RequestData.COLUMN_USER, username);
        v.put(RequestData.COLUMN_SCORE, score);
        v.put(RequestData.COLUMN_IMAGE_RES, imageRes);
        v.put(RequestData.COLUMN_STORE, store);
        v.put(RequestData.COLUN_DISTANCE, distance);

        return v;
    }
}
