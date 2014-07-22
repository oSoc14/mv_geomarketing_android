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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import osoc14.okfn.geomarketing.ListAdapters.MyCouponsCursorAdaptor;
import osoc14.okfn.geomarketing.ListAdapters.MyFavoriteStoresAdaptor;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.activities.StoreDetailActivity;
import osoc14.okfn.geomarketing.contentprovider.CouponContentProvider;
import osoc14.okfn.geomarketing.contentprovider.CouponData;
import osoc14.okfn.geomarketing.contentprovider.FriendsData;
import osoc14.okfn.geomarketing.finaldatabase.Category;
import osoc14.okfn.geomarketing.finaldatabase.Coupon;
import osoc14.okfn.geomarketing.finaldatabase.MyDatabaseHelper;
import osoc14.okfn.geomarketing.finaldatabase.Store;
import osoc14.okfn.geomarketing.model.Friend;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ProfileFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private static final int LOADER_STORES = 5;
    private MyFavoriteStoresAdaptor myFavoriteStoresAdaptor;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        getLoaderManager().initLoader(LOADER_STORES, null, this);
    }

    MyDatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_account, container, false);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "GillSans.ttc");
        //b.setTypeface(tf);

        Button  bttnBarcode = (Button) view.findViewById(R.id.bttnStartBarcodeScan);
        TextView txtView = (TextView) view.findViewById(R.id.txtNameAccount);
        ImageView imgView = (ImageView) view.findViewById(R.id.profilePictureAccount);
        TextView txtViewScore = (TextView) view.findViewById(R.id.txtScoreAccount);

        bttnBarcode.setTypeface(tf);
        txtView.setTypeface(tf);
        txtViewScore.setTypeface(tf);


        bttnBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent("com.google.zxing.client.android.SCAN");
                in.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(in, 0);
            }
        });
        final Uri myUri = Uri.withAppendedPath(CouponContentProvider.CONTENT_URI_ONE_FRIENDS, "5");

        Cursor c = getActivity().getContentResolver().query(myUri, null, null, null, null);
        if ( c.moveToFirst() ) {

            txtView.setText(c.getString(c.getColumnIndex(FriendsData.COLUMN_NAME)));
            imgView.setImageResource(R.drawable.pic_profile);
            //txtViewScore.setText(Integer.toString(c.getInt(c.getColumnIndex(FriendsData.COLUMN_SCORE)))+" points");

        }

        //ListView list = (ListView) view.findViewById(R.id.list_favorite_stores);
        GridView grid = (GridView) view.findViewById(R.id.grid_favorite_stores);

        myFavoriteStoresAdaptor = new MyFavoriteStoresAdaptor(getActivity(), null, 0);
        //list.setAdapter(myFavoriteStoresAdaptor);
        grid.setAdapter(myFavoriteStoresAdaptor);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                startActivity(StoreDetailActivity.newIntent(getActivity(), (int) id));
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        switch (id)
        {
            case LOADER_STORES:

                Log.d("data", ">>>>> onCreateLoader");
                //final Uri uri = Uri.withAppendedPath(CouponContentProvider.CONTENT_URI_ALL_COUPONS, null);
                //final Uri uri = Uri.withAppendedPath(CouponContentProvider.CONTENT_URI_ALL_COUPONS, null);
                return new CursorLoader(getActivity(), CouponContentProvider.CONTENT_URI_FAVORITE_STORES, null, null, null, null);


            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> objectLoader, Cursor o) {
        switch (objectLoader.getId()) {
            case LOADER_STORES:
                Log.d("data", ">>>>> onFinishLoader");
                if (!o.isClosed() && o.moveToFirst()) {
                    myFavoriteStoresAdaptor.swapCursor(o);
                }
                break;

            default:
                break;
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> objectLoader) {

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
