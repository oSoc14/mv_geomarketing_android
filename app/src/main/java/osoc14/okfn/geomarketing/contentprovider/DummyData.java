package osoc14.okfn.geomarketing.contentprovider;

import android.app.Activity;
import android.view.animation.AccelerateInterpolator;

import osoc14.okfn.geomarketing.R;
import osoc14.okfn.geomarketing.model.ActivityFriend;
import osoc14.okfn.geomarketing.model.Coupon;
import osoc14.okfn.geomarketing.model.Friend;
import osoc14.okfn.geomarketing.model.Request;

/**
 * Created by Samuel on 08/07/14.
 */
public class DummyData {

    public static void insertDummyData (Activity a) {

        //Food
        Coupon coupon1 = new Coupon("Graties aperitief", "Bij 2 gangen menu", "Bonafide", "Food", R.drawable.logo_bona, "dummy qr code", 34, R.drawable.poi_bena_s, R.drawable.poi_bena, 51.04297640529123,3.7236547842621803, 0);
        Coupon coupon2 = new Coupon("Frikadel special graties", "Actie vanaf groot pak friet met saus", "Stas-Dejong", "Food", R.drawable.logo_stas, "dummy qr code", 21, R.drawable.poi_stass_s, R.drawable.poi_stass, 51.040721627158064,3.7244457006454463, 0);
        Coupon coupon3 = new Coupon("Graties pint bij frietjes", "Actie vanaf groot pak friet met saus", "Frituur bar & café", "Food", R.drawable.logo_frit, "dummy qr code", 3, R.drawable.poi_frit_s, R.drawable.poi_frit, 51.04291506227478,3.7256483361124997, 1);
        Coupon coupon4 = new Coupon("Supersized bicky burger", "Bicky burgers met dubbele burger", "Funky frituur", "Food", R.drawable.logo_funk, "dummy qr code", 98 ,R.drawable.poi_funk_s, R.drawable.poi_funk,51.04077053525275,3.727819919586181, 0);
        Coupon coupon5 = new Coupon("Digestief van huis", "Geldig op alle gerechten", "Ravioli's", "Food", R.drawable.logo_rav, "dummy qr code", 19, R.drawable.poi_rav_s, R.drawable.poi_rav,51.04181087408855,3.729371912777424, 0);
        Coupon coupon6 = new Coupon("Smart lunch 10 euro", "Proef onze gezonde smart luch menu", "Bistro Smartfood", "Food", R.drawable.logo_smart, "dummy qr code", 19, R.drawable.poi_smart_s, R.drawable.poi_smart,51.038746708891274,3.7262142822146416, 1);
        Coupon coupon7 = new Coupon("Yellow-menu aan 12 euro", "Menu is exclusief drank", "Yellow", "Food", R.drawable.logo_yel, "dummy qr code", 19, R.drawable.poi_yel_s, R.drawable.poi_yel,51.04121154901604,3.7248969823122025, 0);

        //Bars

        //Electronics

        //Clothing
        Coupon coupon8 = new Coupon("Badpakken promoties tot 15%", "Op de volledige zomer collectie", "H&M", "Clothing", R.drawable.logo_hm, "dummy qr code" , 14, R.drawable.poi_hm_s, R.drawable.poi_hm, 51.04103278294871,3.725546076893806, 0);
        Coupon coupon9 = new Coupon("Extra 10% op uw aankoop", "Niet geldig op lingerie artikelen", "JBC", "Clothing", R.drawable.logo_jbc, "dummy qr code", 41, R.drawable.poi_jbc_s, R.drawable.poi_jbc,51.04233366979013,3.7257636711001396, 0);
        Coupon coupon10 = new Coupon("Kies uw graties accesoire", "Bij aankoop vanaf 2 producten", "Pull & Bear", "Clothing", R.drawable.logo_pb, "dummy qr code", 25, R.drawable.poi_pb_s, R.drawable.poi_pb, 51.03942680873707,3.7257603183388714, 1);
        Coupon coupon11 = new Coupon("30% op alle winterjassen", "Niet geldig op de nieuwe collectie", "WE", "Clothing", R.drawable.logo_we, "dummy qr code", 25, R.drawable.poi_we_s, R.drawable.poi_we, 51.04024202995975,3.725617155432701, 0);

        //Varia
        Coupon coupon12 = new Coupon("AH slaatjes promotie", "-35% op alle maaltijdsalades", "Albert Heijn" , "Varia", R.drawable.logo_ah , "dummy qr code", 12, R.drawable.poi_ah_s, R.drawable.poi_ah, 51.04264629036875,3.727906085550785, 1);
        Coupon coupon13 = new Coupon("Jupiler aan halve prijs", "Actie op Jupiler per bak ", "Carrefour", "Varia", R.drawable.logo_car,  "dummy qr code", 23, R.drawable.poi_car_s, R.drawable.poi_car, 51.0428421251117,3.72286219149828, 0);
        Coupon coupon14 = new Coupon("20% op alle aankopen", "Niet cummuleerbaar met andere acties", "Delaize", "Varia", R.drawable.logo_del, "dummy qr code", 9, R.drawable.poi_del_s, R.drawable.poi_del, 51.041748686303976,3.7239203229546547, 0);
        Coupon coupon15 = new Coupon("Meergranen brood actie ", "20% korting op meergranen broden", "Lidl", "Varia", R.drawable.logo_lidl, "dummy qr code", 17, R.drawable.poi_lidl_s, R.drawable.poi_lidl, 51.039584077769995,3.7243478000164036, 0);


        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon1.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon2.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon3.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon4.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon5.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon6.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon7.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon8.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon9.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon10.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon11.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon12.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon13.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon14.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_COUPONS, coupon15.getContentValues());

    }



    public static void insertDummyFriends (Activity a){

        Friend f1 = new Friend("Samuel Vandecasteele", 312, R.drawable.samuel);
        Friend f2 = new Friend("Jasper De Rocker", 212, R.drawable.jasper);
        Friend f3 = new Friend("Thomas Ghysels", 112, R.drawable.thomas);
        Friend f4 = new Friend("Niels Dewelde", 73, R.drawable.niels);
        Friend f5 = new Friend("Faustine Maus", 67, R.drawable.faustine);
        Friend f6 = new Friend("Peter Neyens", 54, R.drawable.peter);
        Friend f7 = new Friend("Michiel De Wilde", 12, R.drawable.michiel);

        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_FRIENDS, f1.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_FRIENDS, f2.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_FRIENDS, f3.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_FRIENDS, f4.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_FRIENDS, f5.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_FRIENDS, f6.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_FRIENDS, f7.getContentValues());

    }

    public static void insertDummyActivities (Activity a) {

        ActivityFriend a1 = new ActivityFriend("Badpakken promoties tot 15%", "Thomas Ghysels", "H&M", 12, R.drawable.thomas);
        ActivityFriend a2 = new ActivityFriend("Friet met mayo en frikandel aan 3 euro",  "Samuel Vandecasteele","Frituur Nadine", 12, R.drawable.samuel);
        ActivityFriend a3 = new ActivityFriend("Pitta festijn", "Michiel De Wilde", "Pitta festijn", 12, R.drawable.michiel);
        ActivityFriend a4 = new ActivityFriend("AH slaatjes promotie", "Peter Neyens", "Albert Heijn" , 12, R.drawable.peter);
        ActivityFriend a5 = new ActivityFriend("5 euro korting op alle android-smartphones", "Niels Dewelde", "Media Markt", 12, R.drawable.niels);

        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_ACTIVITIES, a1.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_ACTIVITIES, a2.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_ACTIVITIES, a3.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_ACTIVITIES, a4.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_ACTIVITIES, a5.getContentValues());

    }

    public static void insertDummyRequests (Activity a) {

        Request r1 = new Request("Graties proevertjes", "Samuel Vandecasteele", "De zuivelfabriek", 12, 23.2, R.drawable.melk);
        Request r2 = new Request("Alles aan halve prijs", "Faustine Maus", "Frituur Nadine", 12, 54.2, R.drawable.fries_action);

        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_REQUESTS, r1.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_REQUESTS, r2.getContentValues());

    }

}
