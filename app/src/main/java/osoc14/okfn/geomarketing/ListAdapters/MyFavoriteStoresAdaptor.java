package osoc14.okfn.geomarketing.ListAdapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.contentprovider.CouponData;

/**
 * Created by Samuel on 11/07/14.
 */
public class MyFavoriteStoresAdaptor extends CursorAdapter {
    public MyFavoriteStoresAdaptor(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View retView = inflater.inflate(R.layout.list_item_stores, viewGroup, false);
        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ImageView imgView = (ImageView) view.findViewById(R.id.imageView_favorite_store);
        imgView.setImageResource(cursor.getInt(cursor.getColumnIndex(CouponData.COLUMN_IMAGE_RES)));


    }
}
