package osoc14.okfn.geomarketing.ListAdapters;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import osoc14.okfn.geomarketing.LLOG;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.contentprovider.CouponData;

/**
 * Created by Samuel on 08/07/14.
 */
public class MyCouponsCursorAdaptor extends CursorAdapter {


    public MyCouponsCursorAdaptor(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View retView = inflater.inflate(R.layout.list_item_coupon, viewGroup, false);

        return retView;

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = (TextView) view.findViewById(R.id.txtTitleCoupon);
        txtName.setText(cursor.getString((cursor.getColumnIndex(CouponData.COLUMN_NAME))));

        TextView txtDist = (TextView) view.findViewById(R.id.txtDistanceCoupon);
        txtDist.setText("23.1 km");

        TextView txtStore = (TextView) view.findViewById(R.id.txtStoreCoupon);
        txtStore.setText("Winkel");

        TextView txtPoints = (TextView) view.findViewById(R.id.txtPointsCoupon);
        txtPoints.setText("212 points");

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewCoupon);
        imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(CouponData.COLUMN_IMAGE_RES)));

    }

}
