package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import osoc14.okfn.geomarketing.MyGoogleMapHelper;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.contentprovider.CouponContentProvider;
import osoc14.okfn.geomarketing.model.Coupon;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailCouponFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailCouponFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DetailStoreFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private int coupon_id;
    private String mParam2;

    private Coupon coupon;

    private OnFragmentInteractionListener mListener;
    private static final String ARG_COUPON_ID = "coupon_id";

    private GoogleMap googleMap;
    private MyGoogleMapHelper mapHelper;
    MapView mapView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailCoupon.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailStoreFragment newInstance(int coupon_id, String param2) {
        DetailStoreFragment fragment = new DetailStoreFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUPON_ID, coupon_id);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public DetailStoreFragment() {
        // Required empty public constructor
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            coupon_id = getArguments().getInt(ARG_COUPON_ID);
        }

        final Uri myUri = Uri.withAppendedPath(CouponContentProvider.CONTENT_URI_ONE_COUPON, Integer.toString(coupon_id));
        Cursor c = getActivity().getContentResolver().query(myUri, null, null, null, null);

        coupon = Coupon.getCoupon(c);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_store, container, false);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.myMapStore);
        mapView.onCreate(savedInstanceState);

        MapsInitializer.initialize(getActivity());

        googleMap = mapView.getMap();
        mapHelper = new MyGoogleMapHelper(googleMap);
        mapHelper.initializeMapTwo();
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "GillSans.ttc");

        TextView txtTitle = (TextView) v.findViewById(R.id.txtTitleStore);
        txtTitle.setTypeface(tf);
        txtTitle.setText(coupon.getStore());

        TextView txtSummary = (TextView) v.findViewById(R.id.txtStoreDetailStore);
        txtSummary.setTypeface(tf);
        txtSummary.setText("");

        ImageView imgView = (ImageView) v.findViewById(R.id.imageViewDetailStore);
        imgView.setImageResource(coupon.getImageRes());

        mapHelper.zoomMap(new LatLng(coupon.getLat(), coupon.getLng()));
        mapHelper.setMarker(coupon.getLat(), coupon.getLng(), coupon.getImageMarker_s(), coupon.getStore());

        return v;
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
