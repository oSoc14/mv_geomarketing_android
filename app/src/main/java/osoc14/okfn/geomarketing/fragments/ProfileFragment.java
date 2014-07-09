package osoc14.okfn.geomarketing.fragments;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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

import java.util.List;

import osoc14.okfn.geomarketing.R;
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
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

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
    }

    MyDatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_account, container, false);

        Button  bttnBarcode = (Button) view.findViewById(R.id.bttnStartBarcodeScan);
        TextView txtView = (TextView) view.findViewById(R.id.txtNameAccount);
        ImageView imgView = (ImageView) view.findViewById(R.id.profilePictureAccount);
        TextView txtViewScore = (TextView) view.findViewById(R.id.txtScoreAccount);


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
            bttnBarcode.setText(c.getString(c.getColumnIndex(FriendsData.COLUMN_NAME)));
            txtView.setText(c.getString(c.getColumnIndex(FriendsData.COLUMN_NAME)));
            imgView.setImageResource(c.getInt(c.getColumnIndex(FriendsData.COLUMN_IMAGE_RES)));
            txtViewScore.setText(Integer.toString(c.getInt(c.getColumnIndex(FriendsData.COLUMN_SCORE)))+" points");

        }






        //nieweData();
        return view;
    }

    public void nieweData() {
        db = new MyDatabaseHelper(getActivity().getApplicationContext());

        //Create categories
        Category category1 = new Category("Kleding");
        category1.setId(1);
        Category category2 = new Category("Multimedia");
        category2.setId(2);
        Category category3 = new Category("Pubs & bars");
        category3.setId(3);
        Category category4 = new Category("Restaurant");
        category4.setId(4);
        Category category5 = new Category("Supermarkt");
        category5.setId(5);
        Category category6 = new Category("Voeding");
        category6.setId(6);

        long category1_id = db.createCategory(category1);
        long category2_id = db.createCategory(category2);
        long category3_id = db.createCategory(category3);
        long category4_id = db.createCategory(category4);
        long category5_id = db.createCategory(category5);
        long category6_id = db.createCategory(category6);

        //Create stores
        Store store1 = new Store("Bakker Jos", "Beste brood van het stad", 51.04157350602823,3.726298436522484);
        store1.setId(1);
        Store store2 = new Store("H&M", "Dress to impress", 51.04157350602823,3.726298436522484);
        store2.setId(2);
        Store store3 = new Store("Pitta Istanbul", "Lekker vettig", 51.04157350602823,3.726298436522484);
        store3.setId(3);
        Store store4 = new Store("De zuivelfabriek", "Kaas, melk en nog veel meer", 51.04157350602823,3.726298436522484);
        store4.setId(4);
        Store store5 = new Store("Slager bart", "Niets beter dan vers vlees", 51.04157350602823,3.726298436522484);
        store5.setId(5);
        Store store6 = new Store("Frituur Nadine", "Goudgele kunsten", 51.04157350602823,3.726298436522484);
        store6.setId(6);
        Store store7 = new Store("Café de loge", "Gezellig sfeercafé", 51.04157350602823,3.726298436522484);
        store7.setId(7);
        Store store8 = new Store("Faits diver", "Stijlvol restaurant in het centrum", 51.04157350602823,3.726298436522484);
        store8.setId(8);
        Store store9 = new Store("FNAC", "Van boeken to plasma tv's", 51.04157350602823,3.726298436522484);
        store9.setId(9);
        Store store10 = new Store("Colruyt", "Altijd de laagste prijs", 51.04157350602823,3.726298436522484);
        store10.setId(10);
        Store store11 = new Store("Albert Heijn", "Boodschappen doen in stijl", 51.04157350602823,3.726298436522484);
        store11.setId(11);

        long store1_id = db.createStore(store1);
        long store2_id = db.createStore(store2);
        long store3_id = db.createStore(store3);
        long store4_id = db.createStore(store4);
        long store5_id = db.createStore(store5);
        long store6_id = db.createStore(store6);
        long store7_id = db.createStore(store7);
        long store8_id = db.createStore(store8);
        long store9_id = db.createStore(store9);
        long store10_id = db.createStore(store10);
        long store11_id = db.createStore(store11);

        // Creating coupons
        Coupon coupon1 = new Coupon("20 % korting", "Actie alleen geldig bij aankoop van 2 producten", store2_id, category1_id, "imageURI/KOK", "dummy qr code");
        coupon1.setId(1);
        Coupon coupon2 = new Coupon("Alles aan halve prijs", "Actie alleen geldig bij aankoop van 2 producten", store4_id, category6_id,"imageURI/KOK", "dummy qr code");
        coupon2.setId(2);
        Coupon coupon3 = new Coupon("Graties proevertjes", "Actie alleen geldig bij aankoop van 2 producten", store4_id, category6_id, "imageURI/KOK", "dummy qr code");
        coupon3.setId(3);
        Coupon coupon4 = new Coupon("Pitta festijn", "Actie alleen geldig bij aankoop van 2 producten", store3_id, category4_id, "imageURI/KOK",  "dummy qr code");
        coupon4.setId(4);
        Coupon coupon5 = new Coupon("Zuivelweek ", "Actie alleen geldig bij aankoop van 2 producten", store4_id, category6_id, "imageURI/KOK", "dummy qr code");
        coupon5.setId(5);
        Coupon coupon6 = new Coupon("Gratis droge worst", "Actie alleen geldig bij aankoop van 2 producten", store5_id, category6_id, "imageURI/KOK", "dummy qr code");
        coupon6.setId(6);
        Coupon coupon7 = new Coupon("5 euro korting op alle android-smartphones", "Actie geldig zolang de rode duivels winnen", store9_id, category2_id, "imageURI/KOK", "dummy qr code" );
        coupon7.setId(7);
        Coupon coupon8 = new Coupon("AH slaatjes promotie", "-35% op alle AH maaltijdsalades", store11_id, category5_id, "imageURI/KOK", "dummy qr code");
        coupon8.setId(8);
        Coupon coupon9 = new Coupon("Fanta en cola actie", "-10% op alle frisdrank petflessen van Coca-cola Company", store10_id, category5_id,"imageURI/KOK", "dummy qr code");
        coupon9.setId(9);
        Coupon coupon10 = new Coupon("Aperetief van het huis bij drie gangen menu", "Alleen geldig tijdens de lunch", store8_id, category4_id, "imageURI/KOK", "dummy qr code");
        coupon10.setId(10);
        Coupon coupon11 = new Coupon("Gratis inkom bij het optreden van Coldplay", "Maximum 150 personen in het café", store7_id, category3_id, "imageURI/KOK", "dummy qr code");
        coupon11.setId(11);
        Coupon coupon12 = new Coupon("Friet met mayo en frikandel aan 3 euro", "actie geldig zolang de vooraat strekt", store6_id, category4_id, "imageURI/KOK", "dummy qr code");
        coupon12.setId(12);
        Coupon coupon13 = new Coupon("Meergranen brood actie ", "Elke ochtent tussen 8 en 10 uur", store1_id, category6_id, "imageURI/KOK", "dummy qr code");
        coupon13.setId(13);
        Coupon coupon14 = new Coupon("Badpakken promoties tot 15%", "Hoera het is zomer", store2_id, store1_id, "imageURI/KOK", "dummy qr code" );
        coupon14.setId(14);

        long coupon1_id = db.createCoupon(coupon1);
        long coupon2_id = db.createCoupon(coupon2);
        long coupon3_id = db.createCoupon(coupon3);
        long coupon4_id = db.createCoupon(coupon4);
        long coupon5_id = db.createCoupon(coupon5);
        long coupon6_id = db.createCoupon(coupon6);
        long coupon7_id = db.createCoupon(coupon7);
        long coupon8_id = db.createCoupon(coupon8);
        long coupon9_id = db.createCoupon(coupon9);
        long coupon10_id = db.createCoupon(coupon10);
        long coupon11_id = db.createCoupon(coupon11);
        long coupon12_id = db.createCoupon(coupon12);
        long coupon13_id = db.createCoupon(coupon13);
        long coupon14_id = db.createCoupon(coupon14);


        long coupon_idx;

        List<Coupon> allCoupons = db.getAllCouponsByCategory(category6_id);

        for (Coupon c : allCoupons) {

            Log.d("data", "category 6" + c.getName());

            coupon_idx = c.getId();
            Coupon cl = db.getCoupon( coupon_idx );
            Log.d("data", " nogmaals: " + cl.getName());

        }

        List<Category> categories = db.getAllCategories();

        for ( Category c: categories ) {

            Log.e("data", c.getName());
        }

        Coupon cl = db.getCoupon( 1);
        Log.d("data", " final : " + cl.getName() + cl.getId() );

        Coupon cl2 = db.getCoupon( 3);
        Log.d("data", " final : " + cl2.getName() + cl2.getId() );

        Coupon cl3 = db.getCoupon( 5);
        Log.d("data", " final : " + cl3.getName() + cl3.getId() );





    }
    /*
    public void databankdingen () {
        db = new DatabaseHelper(getActivity().getApplicationContext());

        // Creating Stores
        Category category1 = new Category("Kleding");
        Category category2 = new Category("Multimedia");
        Category category3 = new Category("Pubs & bars");
        Category category4 = new Category("Restaurant");
        Category category5 = new Category("Supermarkt");
        Category category6 = new Category("Voeding");

        // Inserting Stores in db
        long tag1_id = db.createTag(category1);
        long tag2_id = db.createTag(category2);
        long tag3_id = db.createTag(category3);
        long tag4_id = db.createTag(category4);
        long tag5_id = db.createTag(category5);
        long tag6_id = db.createTag(category6);

        Log.d("Store Count", "Store Count: " + db.getAllTags().size());

        // Creating ToDos
        Coupon coupon1 = new Coupon("20 % korting", "Actie alleen geldig bij aankoop van 2 producten", "imageURI/KOK", "Bakker Jos", 213, "dummy qr code");
        Coupon coupon2 = new Coupon("Alles aan halve prijs", "Actie alleen geldig bij aankoop van 2 producten", "imageURI/KOK", "H&M", 120, "dummy qr code");
        Coupon coupon3 = new Coupon("Graties proevertjes", "Actie alleen geldig bij aankoop van 2 producten", "imageURI/KOK", "Slager Bart",78, "dummy qr code");
        Coupon coupon4 = new Coupon("Pitta festijn", "Actie alleen geldig bij aankoop van 2 producten", "imageURI/KOK",  "Pitta Istanbul", 23,  "dummy qr code");
        Coupon coupon5 = new Coupon("Zuivelweek ", "Actie alleen geldig bij aankoop van 2 producten", "imageURI/KOK", "De zuivelfabriek", 54, "dummy qr code");
        Coupon coupon6 = new Coupon("Gratis droge worst", "Actie alleen geldig bij aankoop van 2 producten", "imageURI/KOK",  "Slager Bart",78, "dummy qr code");

        // Inserting todos in db
        // Inserting todos under "Shopping" Tag
        long todo1_id = db.createToDo(coupon1, new long[] { tag1_id });
        long todo2_id = db.createToDo(coupon2, new long[] { tag1_id });
        long todo3_id = db.createToDo(coupon3, new long[] { tag1_id });

        // Inserting todos under "Watchlist" Tag
        long todo4_id = db.createToDo(coupon4, new long[] { tag3_id });
        long todo5_id = db.createToDo(coupon5, new long[] { tag3_id });
        long todo6_id = db.createToDo(coupon6, new long[] { tag3_id });

        Log.e("Coupon Count", "Coupon count: " + db.getToDoCount());

        // Getting all tag names
        Log.d("Get Coupons", "Getting All Coupons");

        List<Category> allCategories = db.getAllTags();
        for (Category category : allCategories) {
            Log.e("Tag Name hihi", category.getTagName() );
        }

        // Getting all Todos
        Log.d("Get Todos", "Getting All ToDos");

        List<Coupon> allToDos = db.getAllToDos();
        for (Coupon coupon : allToDos) {
            Log.e("ToDo", coupon.getName());
        }

        List<Coupon> tagsWatchList = db.getAllToDosByTag(category3.getTagName());
        for (Coupon todo : tagsWatchList) {
            Log.d("ToDo Watchlist", todo.getName());
        }

    }*/

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
