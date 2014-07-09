package osoc14.okfn.geomarketing.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.database.CouponItem;
import osoc14.okfn.geomarketing.finaldatabase.Coupon;
import osoc14.okfn.geomarketing.finaldatabase.MyDatabaseHelper;
import osoc14.okfn.geomarketing.finaldatabase.Store;

/**
 * Created by Samuel on 02/07/14.
 */

public class CouponListAdapter extends ArrayAdapter<Coupon> {

    Context mContext;
    int layoutResourceId;
    List<Coupon> data = null;

    public CouponListAdapter(Context context, int resource, List<Coupon> objects) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.mContext = context;
        this.data = objects;
    }

    public Coupon getCoupon (int position){

        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        if(convertView==null){

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        Coupon couponItem = data.get(position);

        Log.d("data", "name store from coupon" + couponItem.getStoreName());

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitleCoupon);
        txtTitle.setText(couponItem.getName());

        TextView txtStore = (TextView) convertView.findViewById(R.id.txtStoreCoupon);
        txtStore.setText("by " + couponItem.getStore_id());

        TextView txtDistance = (TextView) convertView.findViewById(R.id.txtDistanceCoupon);
        txtDistance.setText("Within " + (couponItem.getQrCode()) + "m");

        ImageView img = (ImageView) convertView.findViewById(R.id.imageViewCoupon);
        img.setImageResource(R.drawable.pitta);

        return convertView;
    }

}
