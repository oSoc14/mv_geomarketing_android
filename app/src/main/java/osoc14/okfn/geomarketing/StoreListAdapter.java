package osoc14.okfn.geomarketing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import osoc14.okfn.geomarketing.database.CouponItem;
import osoc14.okfn.geomarketing.database.StoreItem;

/**
 * Created by Samuel on 02/07/14.
 */
public class StoreListAdapter extends ArrayAdapter<StoreItem> {

    Context mContext;
    int layoutResourceId;
    StoreItem data[] = null;

    public StoreListAdapter(Context context, int resource, StoreItem[] objects) {
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

        StoreItem storeItem = data[position];

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitleStore);
        txtTitle.setText(storeItem.name);

        //ImageView img = (ImageView) convertView.findViewById(R.id.imageView);
        //img.setImageResource(storeItem.resourceIdPicture);

        return convertView;
    }

}
