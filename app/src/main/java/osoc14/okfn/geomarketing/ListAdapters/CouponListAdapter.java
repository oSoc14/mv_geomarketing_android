package osoc14.okfn.geomarketing.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.database.CouponItem;

/**
 * Created by Samuel on 02/07/14.
 */

public class CouponListAdapter extends ArrayAdapter<CouponItem> {

    Context mContext;
    int layoutResourceId;
    CouponItem data[] = null;

    public CouponListAdapter(Context context, int resource, CouponItem[] objects) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.mContext = context;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        if(convertView==null){

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        CouponItem couponItem = data[position];

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitleCoupon);
        txtTitle.setText(couponItem.title);

        TextView txtStore = (TextView) convertView.findViewById(R.id.txtStoreCoupon);
        txtStore.setText("by " + couponItem.store);

        TextView txtDistance = (TextView) convertView.findViewById(R.id.txtDistanceCoupon);
        txtDistance.setText("Within " + Integer.toString(couponItem.distance) + "m");

        ImageView img = (ImageView) convertView.findViewById(R.id.imageViewCoupon);
        img.setImageResource(couponItem.resourceIdPicture);

        return convertView;
    }
}
