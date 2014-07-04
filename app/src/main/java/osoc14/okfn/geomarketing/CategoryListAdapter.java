package osoc14.okfn.geomarketing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import osoc14.okfn.geomarketing.database.CouponItem;

/**
 * Created by Samuel on 03/07/14.
 */
public class CategoryListAdapter extends ArrayAdapter<CouponItem> {

    Context mContext;
    int layoutResourceId;
    CouponItem data[] = null;

    public CategoryListAdapter(Context context, int resource, CouponItem[] objects) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.mContext = context;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        CouponItem couponItem = data[position];
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitleCategory);
        txtTitle.setText(couponItem.title);

        return convertView;
    }
}
