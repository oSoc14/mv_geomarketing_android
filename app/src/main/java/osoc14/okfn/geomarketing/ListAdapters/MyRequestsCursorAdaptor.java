package osoc14.okfn.geomarketing.ListAdapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.contentprovider.ActivityData;
import osoc14.okfn.geomarketing.contentprovider.FriendsData;
import osoc14.okfn.geomarketing.contentprovider.RequestData;

/**
 * Created by Samuel on 09/07/14.
 */
public class MyRequestsCursorAdaptor extends CursorAdapter {
    public MyRequestsCursorAdaptor(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View retView = inflater.inflate(R.layout.list_item_request, viewGroup, false);

        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "GillSans.ttc");
        ImageView img = (ImageView) view.findViewById(R.id.imgProfileRequest);
        img.setImageResource(cursor.getInt(cursor.getColumnIndex(RequestData.COLUMN_IMAGE_RES)));

        TextView txtAction = (TextView) view.findViewById(R.id.txtActionRequest);

        String a = cursor.getString(cursor.getColumnIndex(RequestData.COLUMN_NAME));
        txtAction.setText(a);
        txtAction.setTypeface(tf);

        TextView txtNameUser = (TextView) view.findViewById(R.id.txtNameUserRequest);
        txtNameUser.setTypeface(tf);

        String name[] = (cursor.getString((cursor.getColumnIndex(RequestData.COLUMN_USER)))).split(" ", 2);
        txtNameUser.setText(name[0] +" wants to share !");


    }
}
