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

        Coupon coupon1 = new Coupon("20 % korting", "Actie alleen geldig bij aankoop van 2 producten", "Bakker jos" , "Food", R.drawable.hm , "dummy qr code");
        Coupon coupon2 = new Coupon("Alles aan halve prijs", "Actie alleen geldig bij aankoop van 2 producten", "Frituur Nadine", "Food", R.drawable.fries_action, "dummy qr code");
        Coupon coupon3 = new Coupon("Graties proevertjes", "Actie alleen geldig bij aankoop van 2 producten", "De ZuivelFabriek", "Food", R.drawable.melk, "dummy qr code");
        Coupon coupon4 = new Coupon("Pitta festijn", "Actie alleen geldig bij aankoop van 2 producten", "Pitta Istanbul", "Food", R.drawable.pitta,  "dummy qr code");
        Coupon coupon5 = new Coupon("Zuivelweek ", "Actie alleen geldig bij aankoop van 2 producten", "De ZuivelFabriek", "Food", R.drawable.melk, "dummy qr code");
        Coupon coupon6 = new Coupon("Gratis droge worst", "Actie alleen geldig bij aankoop van 2 producten", "Slagerij bij Bart", "Food", R.drawable.butcher, "dummy qr code");
        Coupon coupon7 = new Coupon("5 euro korting op alle android-smartphones", "Actie geldig zolang de rode duivels winnen", "Media Markt", "Electronics", R.drawable.media, "dummy qr code" );
        Coupon coupon8 = new Coupon("AH slaatjes promotie", "-35% op alle AH maaltijdsalades", "Albert Heijn", "Varia", R.drawable.ah, "dummy qr code");
        Coupon coupon9 = new Coupon("Fanta en cola actie", "-10% op alle frisdrank petflessen van Coca-cola Company", "Colruyt", "Varia", R.drawable.pitta, "dummy qr code");
        Coupon coupon10 = new Coupon("Aperetief van het huis bij drie gangen menu", "Alleen geldig tijdens de lunch", "Faits D'hiver", "Food", R.drawable.resto, "dummy qr code");
        Coupon coupon11 = new Coupon("Gratis inkom bij het optreden van Coldplay", "Maximum 150 personen in het café", "Café de loge", "Bars", R.drawable.deloge, "dummy qr code");
        Coupon coupon12 = new Coupon("Friet met mayo en frikandel aan 3 euro", "actie geldig zolang de vooraat strekt", "Frituur Nadine", "Food", R.drawable.fries_action, "dummy qr code");
        Coupon coupon13 = new Coupon("Meergranen brood actie ", "Elke ochtent tussen 8 en 10 uur", "Bakker Lies", "Food", R.drawable.bread, "dummy qr code");
        Coupon coupon14 = new Coupon("Badpakken promoties tot 15%", "Hoera het is zomer", "H&M", "Clothing", R.drawable.hm, "dummy qr code" );

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

        Request r1 = new Request("Graties proevertjes", "Samuel Vandecasteele", "De zuivelfabriek", 12, 23.2, R.drawable.samuel);
        Request r2 = new Request("Alles aan halve prijs", "Faustine Maus", "Frituur Nadine", 12, 54.2, R.drawable.faustine);

        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_REQUESTS, r1.getContentValues());
        a.getContentResolver().insert(CouponContentProvider.CONTENT_URI_ALL_REQUESTS, r2.getContentValues());

    }

}
