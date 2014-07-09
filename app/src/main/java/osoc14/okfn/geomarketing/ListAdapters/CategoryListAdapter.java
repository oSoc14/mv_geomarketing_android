package osoc14.okfn.geomarketing.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.database.CategoryItem;
import osoc14.okfn.geomarketing.database.CouponItem;
import osoc14.okfn.geomarketing.finaldatabase.Category;

/**
 * Created by Samuel on 03/07/14.
 */
public class CategoryListAdapter extends ArrayAdapter<Category> {

    Context mContext;
    int layoutResourceId;
    List<Category> data = null;
    //CategoryItem data[] = null;

    public CategoryListAdapter(Context context, int resource, List<Category> objects) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.mContext = context;
        this.data = objects;
    }

    public Category getCategory(int position ) {

        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        Category categoryItem = data.get(position);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitleCategory);
        txtTitle.setText(categoryItem.getName());

        return convertView;

    }
}
