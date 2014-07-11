package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import osoc14.okfn.geomarketing.ListAdapters.MyCouponsCursorAdaptor;
import osoc14.okfn.geomarketing.MyGoogleMapHelper;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.activities.CouponDetailActivity;
import osoc14.okfn.geomarketing.contentprovider.CouponContentProvider;
import osoc14.okfn.geomarketing.contentprovider.CouponData;
import osoc14.okfn.geomarketing.contentprovider.DummyData;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class MapFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private SimpleCursorAdapter adapter;
    private MyCouponsCursorAdaptor myAdaptor;
    //private MyGoogleMapHelper googleMapHelper;
    private GoogleMap googleMap;
    private MyGoogleMapHelper mapHelper;

    private String currentCategory = "All";

    private static final int LOADER_COUPON = 1;
    ListView list;
    MapView mapView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getLoaderManager().initLoader(LOADER_COUPON, null, this);



    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_map, container, false);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "GillSans.ttc");
        //b.setTypeface(tf);

        ImageButton b = (ImageButton) v.findViewById(R.id.testButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DummyData.insertDummyData(getActivity());
                DummyData.insertDummyFriends(getActivity());
                DummyData.insertDummyActivities(getActivity());
                DummyData.insertDummyRequests(getActivity());
            }
        });

        list = (ListView) v.findViewById(R.id.testListView);
        list.setSelector(R.drawable.selector_listview);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.myMap);
        mapView.onCreate(savedInstanceState);

        MapsInitializer.initialize(getActivity());

        googleMap = mapView.getMap();
        mapHelper = new MyGoogleMapHelper(googleMap);
        mapHelper.initializeMap();
        mapHelper.setStaticPoints();


        myAdaptor = new MyCouponsCursorAdaptor(getActivity(), null, 0, mapHelper);
        list.setAdapter(myAdaptor);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                startActivity(CouponDetailActivity.newIntent(getActivity(), (int) id));
            }
        });

        final Spinner spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("All");
        list.add("Food");
        list.add("Bars");
        list.add("Electronics");
        list.add("Varia");
        list.add("Clothing");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), spinner1.getSelectedItem().toString() + " selected", Toast.LENGTH_SHORT).show();
                currentCategory = spinner1.getSelectedItem().toString();
                restartLoader();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;
    }

    private void restartLoader(){

        //getLoaderManager().destroyLoader(LOADER_COUPON);
        getLoaderManager().restartLoader(LOADER_COUPON, null, this);
        mapHelper.resetMap();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        switch (id)
        {
            case LOADER_COUPON:
                //final Uri uri = Uri.withAppendedPath(CouponContentProvider.CONTENT_URI_ALL_COUPONS, null);
                if (currentCategory == "All") {
                    final Uri uri = CouponContentProvider.CONTENT_URI_ALL_COUPONS;
                    return new CursorLoader(getActivity(), uri, null, null, null, null);
                } else {
                    final Uri uri = Uri.withAppendedPath(CouponContentProvider.CONTENT_URI_COUPONS_BY_CATEGORY, currentCategory);
                    return new CursorLoader(getActivity(), uri, null, null, null, null);
                }

            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        switch (loader.getId())
        {
            case LOADER_COUPON:
                if(!cursor.isClosed() && cursor.moveToFirst())
                {
                    //adapter.swapCursor(cursor);
                    myAdaptor.swapCursor(cursor);

                }
                break;

            default:
                break;
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        myAdaptor.swapCursor(null);
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
        public void onFragmentInteraction(Uri uri);
    }

}
