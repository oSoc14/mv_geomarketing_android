package osoc14.okfn.geomarketing.model;

import android.content.ContentValues;

import osoc14.okfn.geomarketing.contentprovider.ActivityData;

/**
 * Created by Samuel on 09/07/14.
 */
public class ActivityFriend {

    int id;
    String name;
    String username;
    String store;
    int score;
    int imageRes;


    public ActivityFriend() {
    }

    public ActivityFriend(String name, String username, String store, int score, int imageRes) {
        this.name = name;
        this.username = username;
        this.score = score;
        this.imageRes = imageRes;
        this.store = store;
    }

    public ContentValues getContentValues(){
        ContentValues v = new ContentValues();

        v.put(ActivityData.COLUMN_NAME, name);
        v.put(ActivityData.COLUMN_USERNAME, username);
        v.put(ActivityData.COLUMN_SCORE, score);
        v.put(ActivityData.COLUMN_IMAGE_RES, imageRes);
        v.put(ActivityData.COLUMN_STORE, store);

        return v;
    }
}
