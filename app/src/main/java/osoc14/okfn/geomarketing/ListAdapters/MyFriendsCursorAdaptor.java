package osoc14.okfn.geomarketing.ListAdapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.contentprovider.FriendsData;

/**
 * Created by Samuel on 09/07/14.
 */
public class MyFriendsCursorAdaptor extends CursorAdapter {
    public MyFriendsCursorAdaptor(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View retView = inflater.inflate(R.layout.list_item_friend, viewGroup, false);

        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = (TextView) view.findViewById(R.id.profileNameFriend);
        txtName.setText(cursor.getString((cursor.getColumnIndex(FriendsData.COLUMN_NAME))));

        TextView txtScore = (TextView) view.findViewById(R.id.profileScoreFriend);
        txtScore.setText(cursor.getString((cursor.getColumnIndex(FriendsData.COLUMN_SCORE))));

        ImageView imageView = (ImageView) view.findViewById(R.id.profileImageFriend);
        imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(FriendsData.COLUMN_IMAGE_RES)));

    }
}
