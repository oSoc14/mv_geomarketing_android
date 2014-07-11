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

/**
 * Created by Samuel on 09/07/14.
 */
public class MyActivitiesCursorAdaptor extends CursorAdapter {
    public MyActivitiesCursorAdaptor(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View retView = inflater.inflate(R.layout.list_item_activity, viewGroup, false);

        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "GillSans.ttc");

        ImageView img = (ImageView) view.findViewById(R.id.imgProfileActivities);
        img.setImageResource(cursor.getInt(cursor.getColumnIndex(ActivityData.COLUMN_IMAGE_RES)));

        TextView txtAction = (TextView) view.findViewById(R.id.txtNameActionActivities);
        txtAction.setText(cursor.getString(cursor.getColumnIndex(ActivityData.COLUMN_NAME)));
        txtAction.setTypeface(tf);

        TextView txtStore = (TextView) view.findViewById(R.id.txtUserActivities);
        txtStore.setText(cursor.getString(cursor.getColumnIndex(ActivityData.COLUMN_STORE)));
        txtStore.setTypeface(tf);

        TextView txtScore = (TextView) view.findViewById(R.id.txtScoreUserActivities);
        txtScore.setText(Integer.toString(cursor.getInt(cursor.getColumnIndex(ActivityData.COLUMN_SCORE))) + " points");
        txtScore.setTypeface(tf);

    }
}
