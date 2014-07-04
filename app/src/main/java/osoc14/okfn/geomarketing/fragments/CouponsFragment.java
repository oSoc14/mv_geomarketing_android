package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import osoc14.okfn.geomarketing.ListAdapters.CouponListAdapter;
import osoc14.okfn.geomarketing.MyGoogleMapHelper;
import osoc14.okfn.geomarketing.R;

import osoc14.okfn.geomarketing.activities.CouponDetailActivity;
import osoc14.okfn.geomarketing.database.FakeDatabase;
import osoc14.okfn.geomarketing.database.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the
 * interface.
 */
public class CouponsFragment extends Fragment {

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

    // TODO: Rename and change types of parameters
    public static CouponsFragment newInstance(/*String param1, String param2*/) {
        CouponsFragment fragment = new CouponsFragment();
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
    }


    @Override
    public void onResume() {
        super.onResume();

        googleMapHelper.initializeMap();
        googleMapHelper.zoomMap();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        googleMapHelper = new MyGoogleMapHelper(this);

        try {
            googleMapHelper.initializeMap();


        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO: Change Adapter to display your content
        /*
        mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS);
        */
        /*
        mAdapter = new ArrayAdapter<DummyContent.DummyCoupon>(getActivity(),
                R.layout.list_item_coupon, R.id.txtTitleCoupon, DummyContent.COUPONS);
        */

        FakeDatabase fd = new FakeDatabase();
        myCustomAdapter = new CouponListAdapter(getActivity(), R.layout.list_item_coupon, fd.getCouponItemData());

        Intent intent = getActivity().getIntent();
        int number = intent.getIntExtra("object_number", 1);

        Toast.makeText(getActivity(),"Category " + fd.getCategoryItemData()[number].title, Toast.LENGTH_SHORT).show();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_couponsfragment, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(myCustomAdapter);
        mListView.setOnItemClickListener( new AbsListView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity(), CouponDetailActivity.class);
                in.putExtra("object_number", i );
                Toast.makeText(getActivity(), "ojo coupon " + i, Toast.LENGTH_SHORT).show();
                startActivity(in);
            }
        });

        return view;
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
