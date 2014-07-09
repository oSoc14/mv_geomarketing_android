package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;

import osoc14.okfn.geomarketing.MyQRCodeGenerator;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.contentprovider.CouponContentProvider;
import osoc14.okfn.geomarketing.contentprovider.CouponData;
import osoc14.okfn.geomarketing.database.CouponItem;
import osoc14.okfn.geomarketing.database.FakeDatabase;
import osoc14.okfn.geomarketing.finaldatabase.Coupon;
import osoc14.okfn.geomarketing.finaldatabase.MyDatabaseHelper;
import osoc14.okfn.geomarketing.finaldatabase.Store;

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
    private static final String ARG_COUPON_ID = "coupon_id";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int coupon_id;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailCoupon.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailCouponFragment newInstance(int coupon_id, String param2) {
        DetailCouponFragment fragment = new DetailCouponFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUPON_ID, coupon_id);
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

            coupon_id = getArguments().getInt(ARG_COUPON_ID);

            Toast.makeText(getActivity(), Integer.toString(coupon_id), Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_detail_coupon, container, false);

        Intent intent = getActivity().getIntent();
        int number = intent.getIntExtra("COUPON_ID", 1);


        TextView txtViewTitle = (TextView) view.findViewById(R.id.txtTitleDetailCoupon);
        TextView txtViewStoreTitle = (TextView) view.findViewById(R.id.txtStoreDetailCoupon);
        TextView txtViewScore = (TextView) view.findViewById(R.id.txtScoreDetailCoupon);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewDetailCoupon);
        ImageView imageViewQRCode = (ImageView) view.findViewById(R.id.imageViewQRCode);


        final Uri myUri = Uri.withAppendedPath(CouponContentProvider.CONTENT_URI_ONE_COUPON, Integer.toString(coupon_id));
        Cursor c = getActivity().getContentResolver().query(myUri, null, null, null, null);
        if ( c.moveToFirst() ) {
            txtViewTitle.setText(c.getString(c.getColumnIndex(CouponData.COLUMN_NAME)));
            txtViewStoreTitle.setText(c.getString(c.getColumnIndex(CouponData.COLUMN_NAME)));
            txtViewScore.setText(c.getString(c.getColumnIndex(CouponData.COLUMN_CATEGORY)));
            imageView.setImageResource(c.getInt(c.getColumnIndex(CouponData.COLUMN_IMAGE_RES)));
            MyQRCodeGenerator myQRCodeGenerator = new MyQRCodeGenerator();
            imageViewQRCode.setImageBitmap(myQRCodeGenerator.getQRBitmap(c.getString(c.getColumnIndex(CouponData.COLUMN_QR_CODE))));
        }


        Button bttnStartNavigation = (Button) view.findViewById(R.id.bttnStartNavigation);
        bttnStartNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng destination = new LatLng(51.04224998071354,3.7289692461490627);

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + destination.latitude+","+destination.longitude));
                startActivity(i); // misschien de ";" die het probleem is?

            }
        });

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
