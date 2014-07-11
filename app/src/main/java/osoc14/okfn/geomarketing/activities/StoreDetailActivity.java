package osoc14.okfn.geomarketing.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.fragments.DetailCouponFragment;
import osoc14.okfn.geomarketing.fragments.DetailStoreFragment;

/**
 * Created by Samuel on 02/07/14.
 */
public class StoreDetailActivity extends Activity implements DetailStoreFragment.OnFragmentInteractionListener {


    public static final String ARG_COUPON_ID = "arg_coupon_id";


    public static Intent newIntent(Context context, int id)
    {
        final Intent mIntent = new Intent(context, StoreDetailActivity.class);
        mIntent.putExtra(ARG_COUPON_ID, id);
        Log.d("data", "koekoek:   " + Integer.toString(id));
        return mIntent;
    }

    /**
     * Listener for DetailCoupon
     * @param uri
     */
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle data = getIntent().getExtras();
        setContentView(R.layout.activity_detail);
        if(data.containsKey(ARG_COUPON_ID)) {
            data.getInt(ARG_COUPON_ID);
        }
        if (savedInstanceState == null) {


            getFragmentManager().beginTransaction()
                    .add(R.id.container, DetailStoreFragment.newInstance(data.getInt(ARG_COUPON_ID), "a"))
                    .commit();
        }

        initActionBarLayout();

    }

    private void initActionBarLayout() {
        getActionBar().setDisplayShowHomeEnabled(false);

        int titleId = getResources().getIdentifier("action_bar_title", "id",
                "android");

        TextView yourTextView = (TextView) findViewById(titleId);
        yourTextView.setAllCaps(true);
        yourTextView.setTextSize(30);
        yourTextView.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        Typeface tf = Typeface.createFromAsset(getAssets(), "GillSans.ttc");
        yourTextView.setTypeface(tf);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.coupon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
