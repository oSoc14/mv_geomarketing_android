package osoc14.okfn.geomarketing.activities;

import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import osoc14.okfn.geomarketing.MyApp;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.finaldatabase.Category;
import osoc14.okfn.geomarketing.fragments.FriendsFragment;
import osoc14.okfn.geomarketing.fragments.ProfileFragment;
import osoc14.okfn.geomarketing.fragments.CategoryFragment;
import osoc14.okfn.geomarketing.fragments.CouponsFragment;
import osoc14.okfn.geomarketing.fragments.MapFragment;
import osoc14.okfn.geomarketing.fragments.RequestFragment;
import osoc14.okfn.geomarketing.fragments.StoresFragment;

public class MainActivity extends Activity implements ActionBar.TabListener, CouponsFragment.OnFragmentInteractionListener, StoresFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener, FriendsFragment.OnFragmentInteractionListener, RequestFragment.OnFragmentInteractionListener {


    /**
     *  Listener for CouponsFragment and StoresFragment
     * @param id
     */
    @Override
    public void onFragmentInteraction(String id) {

    }

    /**
     *  Listener for AccountFragment
     * @param uri
     */
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (!MyApp.loggedIn) {
            Intent in = new Intent(this, LoginActivity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(in);
        }

        initActionBarLayout();


        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);



        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("data", "onPageScrolled");

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("data", "ScrollStateChanged");
            }

        });



        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.

            ActionBar.Tab t = actionBar.newTab();

            switch (i) {
                case 0:
                    t.setIcon(R.drawable.ic_action_tabs5);
                    break;
                case 1:
                    t.setIcon(R.drawable.ic_action_tabs6);
                    break;
                case 2:
                    t.setIcon(R.drawable.ic_action_tabs7);
                    break;
                case 3:
                    t.setIcon(R.drawable.ic_action_tabs8);
                    break;
            }
            t.setTabListener(this);

            actionBar.addTab(t);
            actionBar.setTitle(R.string.app_name);
        }
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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
        switch (tab.getPosition()) {
            case 0:
                tab.setIcon(R.drawable.ic_action_tabs1);

                break;
            case 1:
                tab.setIcon(R.drawable.ic_action_tabs2);
                break;
            case 2:
                tab.setIcon(R.drawable.ic_action_tabs3);
                break;
            case 3:
                tab.setIcon(R.drawable.ic_action_tabs4);
                break;
        }

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        switch (tab.getPosition()) {
            case 0:
                tab.setIcon(R.drawable.ic_action_tabs5);
                break;
            case 1:
                tab.setIcon(R.drawable.ic_action_tabs6);
                break;
            case 2:
                tab.setIcon(R.drawable.ic_action_tabs7);
                break;
            case 3:
                tab.setIcon(R.drawable.ic_action_tabs8);
                break;
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public void setFragment(int position) {
       mViewPager.setCurrentItem(position);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return CouponsFragmentFragment.newInstance();
            //return MyPlaceholderFragment.newInstance(position + 1);

            switch (position) {
                case 0:
                    return MapFragment.newInstance("a", "b");
                case 1:
                    return ProfileFragment.newInstance("a", "b");
                case 2:
                    return FriendsFragment.newInstance("a", "b");
                case 3:
                    return RequestFragment.newInstance("a", "b");
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_fragment_coupons).toUpperCase(l);
                case 1:
                    return getString(R.string.title_fragment_profile).toUpperCase(l);
                case 2:
                    return getString(R.string.title_fragment_friends).toUpperCase(l);
                case 3:
                    return getString(R.string.title_fragment_request).toUpperCase(l);
            }
            return null;
        }
    }

}
