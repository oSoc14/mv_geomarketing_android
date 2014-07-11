package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import java.util.List;

import osoc14.okfn.geomarketing.ListAdapters.CouponListAdapter;
import osoc14.okfn.geomarketing.MyApp;
import osoc14.okfn.geomarketing.MyGoogleMapHelper;
import osoc14.okfn.geomarketing.R;

import osoc14.okfn.geomarketing.activities.CouponDetailActivity;
import osoc14.okfn.geomarketing.activities.MainActivity;
import osoc14.okfn.geomarketing.database.FakeDatabase;
import osoc14.okfn.geomarketing.database.dummy.DummyContent;
import osoc14.okfn.geomarketing.finaldatabase.Category;
import osoc14.okfn.geomarketing.finaldatabase.Coupon;
import osoc14.okfn.geomarketing.finaldatabase.MyDatabaseHelper;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the
 * interface.
 */
public class CouponsFragment extends Fragment  {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;
    private CouponListAdapter myCustomAdapter;

    private MyGoogleMapHelper googleMapHelper;
    private GoogleMap googleMap;

    private Context c;

    private List<Coupon> data;

    private LocationManager locationManager;
    Location myLocation;

    // TODO: Rename and change types of parameters
    public static CouponsFragment newInstance( Category category) {
        CouponsFragment fragment = new CouponsFragment();
        //fragment.currentCategory = category;
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CouponsFragment() {
        //data = (new MyDatabaseHelper(getActivity().getBaseContext()));

    }



    @Override
    public void onResume() {
        super.onResume();

        //googleMapHelper.initializeMap();
        //googleMapHelper.zoomMap();
        //updateCategory();

    }

    public void updateCategory(){

        Log.d("data", "current category: " + MyApp.currentCategory);
        if (getActivity() == null ){
            Log.d("data", "activity is dus null");
        }

        if (c == null ){
            Log.d("data", "my context is null");
        }
        //googleMapHelper.setStaticPoints();
        //MyDatabaseHelper db = new MyDatabaseHelper(c);
        Log.d("data", "db created");

        //data = db.getAllCouponsByCategory(MyApp.currentCategory);
        Log.d("data", "data created");
        //myCustomAdapter.notifyDataSetChanged();
        Log.d("data", "adaptor notified");
        //myCustomAdapter = new CouponListAdapter(getActivity(), R.layout.list_item_coupon, db.getAllCouponsByCategory(MyApp.currentCategory));
        //mListView.setAdapter(myCustomAdapter);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);
        myLocation = locationManager.getLastKnownLocation(provider);

        Intent intent = getActivity().getIntent();
        int number = intent.getIntExtra("object_number", 1);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_couponsfragment, container, false);

        //int currentCategory = ((MainActivity) getActivity()).getCurrentCategory();

        //Log.d("data", Integer.toString(currentCategory));


        MyDatabaseHelper db = new MyDatabaseHelper(getActivity().getApplicationContext());
        //data = db.getAllCouponsByCategory(currentCategory);
        //myCustomAdapter = new CouponListAdapter(getActivity(), R.layout.list_item_coupon, db.getAllCouponsByCategory(currentCategory));


        // Set the adapter
        mListView = (AbsListView) view.findViewById(R.id.listViewCoupons);
        mListView.setSelector(R.drawable.selector_listview);
        mListView.setAdapter(myCustomAdapter);
        mListView.setOnItemClickListener( new AbsListView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity(), CouponDetailActivity.class);
                in.putExtra("object_number", i );
                Log.d("data", "view: " +view.getId());
                Log.d("data", "position: " + i);
                myCustomAdapter.getItem(i);
                Log.d("data",  "=>>>" + myCustomAdapter.getCoupon(i).getId());
                in.putExtra("coupon_id", myCustomAdapter.getCoupon(i).getId());
                startActivity(in);
            }

        });

        googleMap = ((MapFragment) getFragmentManager().findFragmentById( R.id.myMap)).getMap();
        googleMapHelper = new MyGoogleMapHelper(googleMap);
        googleMapHelper.initializeMap();
        //googleMapHelper.zoomMap(myLocation);
        //googleMapHelper.setLocation(myLocation);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //int currentCategory = ((MainActivity) getActivity()).getCurrentCategory();
        //MyDatabaseHelper db = new MyDatabaseHelper(getActivity().getApplicationContext());
        //myCustomAdapter = new CouponListAdapter(getActivity(), R.layout.list_item_coupon, db.getAllCouponsByCategory(currentCategory));

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("lifecycle", "CouponsFragment onAttach");
        try {
            mListener = (OnFragmentInteractionListener) activity;
            c = activity.getBaseContext();
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("lifecycle", "CouponsFragment onDetach");
        mListener = null;
    }


    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyText instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);


    }

}
