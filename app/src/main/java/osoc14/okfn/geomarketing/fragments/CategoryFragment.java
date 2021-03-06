package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import osoc14.okfn.geomarketing.ListAdapters.CategoryListAdapter;
import osoc14.okfn.geomarketing.MyApp;
import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.activities.CouponDetailActivity;
import osoc14.okfn.geomarketing.activities.MainActivity;
import osoc14.okfn.geomarketing.database.FakeDatabase;
import osoc14.okfn.geomarketing.finaldatabase.Category;
import osoc14.okfn.geomarketing.finaldatabase.MyDatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class CategoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnCategorySelectedListener mListener;
    private AbsListView mListView;
    private CategoryListAdapter myCategoryAdapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //FakeDatabase fd = new FakeDatabase();

        MyDatabaseHelper db = new MyDatabaseHelper(getActivity().getApplicationContext());
        myCategoryAdapter = new CategoryListAdapter(getActivity(), R.layout.list_item_category, db.getAllCategories());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        mListView = (AbsListView) view.findViewById(R.id.listViewCategories);
        mListView.setSelector(R.drawable.selector_listview);
        mListView.setAdapter(myCategoryAdapter);
        mListView.setOnItemClickListener(
            new AbsListView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                     Category category = myCategoryAdapter.getCategory(i);
                     MyApp.currentCategory = category.getId();
                     MyApp.currentCategoryFull = category;
                     if (mListener != null) {
                         mListener.onCategorySelected(category);
                     }
                    /*
                        ((MainActivity) getActivity()).setCurrentCategory(i);
                        Toast.makeText(getActivity(), "set category : " + Integer.toString(i), Toast.LENGTH_SHORT).show();
                        Log.d("data", Integer.toString(((MainActivity) getActivity()).getCurrentCategory()));
                        ((MainActivity) getActivity()).setFragment(1);
                     MyApp.currentCategory = i;
                    */
                 }
            }

        );


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onCategorySelected(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("lifecycle", "CategoryFragment onAttach");
        try {
            mListener = (OnCategorySelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("lifecycle", "CategoryFragment onDetach");
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
    public interface OnCategorySelectedListener {
        // TODO: Update argument type and name
        public void onCategorySelected(Category category);
    }

}
