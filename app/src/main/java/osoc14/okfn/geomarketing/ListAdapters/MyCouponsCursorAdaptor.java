package osoc14.okfn.geomarketing.ListAdapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import osoc14.okfn.geomarketing.LLOG;
import osoc14.okfn.geomarketing.MyGoogleMapHelper;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.contentprovider.CouponData;

/**
 * Created by Samuel on 08/07/14.
 */
public class MyCouponsCursorAdaptor extends CursorAdapter {

    MyGoogleMapHelper myGoogleMapHelper;
    Typeface tf;


    public MyCouponsCursorAdaptor(Context context, Cursor c, int flags, MyGoogleMapHelper myGoogleMapHelper) {
        super(context, c, flags);
        this.myGoogleMapHelper = myGoogleMapHelper;

        tf = Typeface.createFromAsset(context.getAssets(), "GillSans.ttc");
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View retView = inflater.inflate(R.layout.list_item_coupon, viewGroup, false);

        return retView;

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        final TextView txtName = (TextView) view.findViewById(R.id.txtTitleCoupon);
        txtName.setText(cursor.getString((cursor.getColumnIndex(CouponData.COLUMN_NAME))));
        txtName.setTypeface(tf);

        final TextView txtStore = (TextView) view.findViewById(R.id.txtStoreCoupon);
        txtStore.setText(cursor.getString(cursor.getColumnIndex(CouponData.COLUMN_STORE)));
        txtStore.setTypeface(tf);


        TextView txtPoints = (TextView) view.findViewById(R.id.txtPointsCoupon);
        txtPoints.setText(Integer.toString(cursor.getInt(cursor.getColumnIndex(CouponData.COLUMN_POINTS)))+ " points");

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewCoupon);
        imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(CouponData.COLUMN_IMAGE_RES)));
/*
        double lat = cursor.getDouble(cursor.getColumnIndex(CouponData.COLUMN_LAT));
        double lng = cursor.getDouble(cursor.getColumnIndex(CouponData.COLUMN_LNG));
        int img = cursor.getInt(cursor.getColumnIndex(CouponData.COLUMN_IMAGE_MARKER_U));
        String title = cursor.getString(cursor.getColumnIndex(CouponData.COLUMN_STORE));
        myGoogleMapHelper.setMarker(lat, lng, img, title);
*/

    }

}
