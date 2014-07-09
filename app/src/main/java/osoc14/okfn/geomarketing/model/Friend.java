package osoc14.okfn.geomarketing.model;

import android.content.ContentValues;

import osoc14.okfn.geomarketing.contentprovider.FriendsData;

/**
 * Created by Samuel on 09/07/14.
 */
public class Friend {

    String name;
    int score;
    int imageRes;

    public Friend() {
    }

    public Friend(String name, int score, int imageRes) {
        this.name = name;
        this.score = score;
        this.imageRes = imageRes;
    }

    public ContentValues getContentValues(){
        ContentValues v = new ContentValues();

        v.put(FriendsData.COLUMN_NAME, name);
        v.put(FriendsData.COLUMN_SCORE, score);
        v.put(FriendsData.COLUMN_IMAGE_RES, imageRes);

        return v;
    }
}
