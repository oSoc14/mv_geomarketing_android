package osoc14.okfn.geomarketing.database;

import com.google.android.gms.maps.model.LatLng;

import osoc14.okfn.geomarketing.R;

/**
 * Created by Samuel on 02/07/14.
 */
public class FakeDatabase {



    CouponItem[] couponItemData;

    StoreItem[] storeItemData;

    CategoryItem[] categoryItemData;

    LatLng [] locations;

    public FakeDatabase(){

        //Set coupon data
        couponItemData = new CouponItem[10];
        couponItemData[0] = new CouponItem("1", "Eén pak graties", "Frituur nadine", "summary", R.drawable.fries_action, 234);
        couponItemData[1] = new CouponItem("2", "20% korting", "Bakker jos","summary", R.drawable.bread, 300);
        couponItemData[2] = new CouponItem("3", "Eindejaarsactie", "Pitta Istanbul", "summary", R.drawable.pitta, 178);
        couponItemData[3] = new CouponItem("4", "2de pint graties", "Café de loge", "summary", R.drawable.deloge, 40);
        couponItemData[4] = new CouponItem("5", "Graties worst", "Slager Bart", "summary", R.drawable.butcher, 439);
        couponItemData[5] = new CouponItem("6", "1 blikje graties", "Pitta istanbul", "summary", R.drawable.pitta, 178);
        couponItemData[6] = new CouponItem("7", "2de stuk aan halve prijs", "H&M", "summary", R.drawable.hm, 200);
        couponItemData[7] = new CouponItem("8", "Nieuwe vleessalade", "Slager Bart", "summary", R.drawable.butcher, 439);
        couponItemData[8] = new CouponItem("9", "Valentijn actie", "Frituur nadine", "summary", R.drawable.fries_shop, 234);
        couponItemData[9] = new CouponItem("10", "Graties inkom Coldplay", "Café de loge", "summary", R.drawable.deloge, 40);


        //Set store date
        storeItemData = new StoreItem[6];
        storeItemData[0] = new StoreItem("1", "Frituur nadine", "Frituur nadine", "summary", R.drawable.fries_action, false);
        storeItemData[1] = new StoreItem("2", "Bakker jos", "Bakker jos","summary", R.drawable.bread, false);
        storeItemData[2] = new StoreItem("3", "Pitta Istanbul", "Pitta Istanbul", "summary", R.drawable.pitta, false);
        storeItemData[3] = new StoreItem("4", "Café de loge", "Café de loge", "summary", R.drawable.deloge, false);
        storeItemData[4] = new StoreItem("5", "Slager bart", "Slager Bart", "summary", R.drawable.butcher, false);
        storeItemData[5] = new StoreItem("5", "h&m", "h&m", "summary", R.drawable.hm, false);

        //Set Category dummy data
        categoryItemData = new CategoryItem[4];
        categoryItemData[0] = new CategoryItem("1", "Kledij", R.drawable.hm);
        categoryItemData[1] = new CategoryItem("2", "Voeding", R.drawable.hm);
        categoryItemData[2] = new CategoryItem("3", "Cafees", R.drawable.hm);
        categoryItemData[3] = new CategoryItem("4", "Restaurant", R.drawable.hm);


        //

        locations = new LatLng[5];

        locations[0] = new LatLng(51.041377455114635,3.7252557277679443);
        locations[1] = new LatLng(51.04075809742324,3.7268670648336415);
        locations[2] = new LatLng(51.03956383942572,3.7260090932250023);
        locations[3] = new LatLng(51.04240386731209,3.721863068640232);
        locations[4] = new LatLng(51.04224998071354,3.7289692461490627);
    }

    public CouponItem[] getCouponItemData() {
        return couponItemData;
    }

    public StoreItem[] getStoreItemData() {
        return storeItemData;
    }

    public CategoryItem[] getCategoryItemData() {
        return  categoryItemData;
    }

    public LatLng[] getLocations() {
        return locations;
    }
}
