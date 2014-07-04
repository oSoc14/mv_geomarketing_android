package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.database.CouponItem;
import osoc14.okfn.geomarketing.database.FakeDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailCouponFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailCouponFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DetailCouponFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private GoogleMap googleMap;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailCoupon.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailCouponFragment newInstance(String param1, String param2) {
        DetailCouponFragment fragment = new DetailCouponFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public DetailCouponFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        try {
            initGoogleMap();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initGoogleMap(){
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getActivity(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detail_coupon, container, false);

        Intent intent = getActivity().getIntent();
        int number = intent.getIntExtra("object_number", 1);

        FakeDatabase fd = new FakeDatabase();
        CouponItem[] coupons =  fd.getCouponItemData();

        CouponItem currentCoupon = coupons[number];

        TextView txtViewTitle = (TextView) view.findViewById(R.id.txtTitleDetailCoupon);
        txtViewTitle.setText(currentCoupon.title);

        int resultcode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());

        Toast.makeText(getActivity(), "available code" + Integer.toString(resultcode), Toast.LENGTH_SHORT).show();

        TextView txtViewStoreTitle = (TextView) view.findViewById(R.id.txtStoreDetailCoupon);
        txtViewStoreTitle.setText(currentCoupon.store);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewDetailCoupon);
        imageView.setImageResource(currentCoupon.resourceIdPicture);

        return view;
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
