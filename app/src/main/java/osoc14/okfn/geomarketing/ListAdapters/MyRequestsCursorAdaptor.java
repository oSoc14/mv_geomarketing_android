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
import osoc14.okfn.geomarketing.contentprovider.ActivityData;
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
        ImageView img = (ImageView) view.findViewById(R.id.imgProfileRequest);
        img.setImageResource(cursor.getInt(cursor.getColumnIndex(RequestData.COLUMN_IMAGE_RES)));

        TextView txtAction = (TextView) view.findViewById(R.id.txtNameActionRequest);
        txtAction.setText(cursor.getString(cursor.getColumnIndex(RequestData.COLUMN_NAME)));

        TextView txtStore = (TextView) view.findViewById(R.id.txtUserRequest);
        txtStore.setText(cursor.getString(cursor.getColumnIndex(RequestData.COLUMN_STORE)));

        TextView txtScore = (TextView) view.findViewById(R.id.txtScoreRequest);
        txtScore.setText(Integer.toString(cursor.getInt(cursor.getColumnIndex(RequestData.COLUMN_SCORE))));

    }
}
