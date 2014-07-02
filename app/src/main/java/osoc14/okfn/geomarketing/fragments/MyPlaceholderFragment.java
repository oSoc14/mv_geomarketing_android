package osoc14.okfn.geomarketing.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.database.DataProvider;

/**
 * A placeholder fragment containing a simple view.
 */
public class MyPlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MyPlaceholderFragment newInstance(int sectionNumber) {
        MyPlaceholderFragment fragment = new MyPlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MyPlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        DataProvider dataProvider = new DataProvider();
        //TextView txtView = (TextView) getActivity().findViewById(R.id.section_label);
        //txtView.setText("okidoki");
        //dataProvider.attachData(txtView);

    }
}