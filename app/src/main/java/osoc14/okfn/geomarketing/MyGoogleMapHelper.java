package osoc14.okfn.geomarketing;

import android.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import osoc14.okfn.geomarketing.database.FakeDatabase;

/**
 * Created by Samuel on 04/07/14.
 */
public class MyGoogleMapHelper {

    private GoogleMap googleMap;
    private Fragment context;

    private MyOnClickMapListener myOnClickMapListener;

    private LatLng myDummyLocation = new LatLng(51.04140612497747,3.725198395550251);


    public MyGoogleMapHelper( GoogleMap googleMap ) {
        this.googleMap = googleMap;
        LLOG.logg("MyGoogleMapHelper made");

    }

    public void initializeMap() {
        LLOG.logg("initializeMap()");


        if (googleMap != null) {

            googleMap.setOnMapClickListener(new MyOnClickMapListener(googleMap));
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
            googleMap.getUiSettings().setCompassEnabled(false);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(false);
            zoomMap( myDummyLocation );
            //drawCircle();
            //setStaticPoints();


        } else {
            LLOG.logg("googleMap is null");
        }

    }

    public  void initializeMapTwo() {
        LLOG.logg("initializeMap()");


        if (googleMap != null) {

            googleMap.setOnMapClickListener(new MyOnClickMapListener(googleMap));
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
            googleMap.getUiSettings().setCompassEnabled(false);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(false);



        } else {
            LLOG.logg("googleMap is null");
        }

    }

    public void resetMap () {
        googleMap.clear();
        drawCircle();
    }

    public void setLocation(Location location) {

    }

    public void drawCircle() {
        final CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(myDummyLocation);
        circleOptions.radius(350);
        circleOptions.strokeColor(R.drawable.purple);
        circleOptions.fillColor(R.drawable.purple);
        final Circle circle = googleMap.addCircle(circleOptions);
    }

    public  void zoomMap(LatLng latLng) {

        CameraUpdate center= CameraUpdateFactory.newLatLng(latLng);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);

    }

    public void setStaticPoints() {
        FakeDatabase fd = new FakeDatabase();

        LatLng[] points = fd.getLocations();

        for (int i= 0; i < points.length; i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(points[i]);
            markerOptions.title(fd.getStoreItemData()[i].name);
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.poi_hm));
            googleMap.addMarker(markerOptions);
        }


    }

    public void setMarker( double lat, double lng, int imgResource, String title ) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(lat, lng));
        markerOptions.title(title);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(imgResource));
        googleMap.addMarker(markerOptions);
    }

    private static class MyOnClickMapListener implements GoogleMap.OnMapClickListener {

        private GoogleMap googleMap;

        public MyOnClickMapListener (GoogleMap googleMap) {
            this.googleMap = googleMap;

        }

        @Override
        public void onMapClick(LatLng point) {

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(point);
            googleMap.addMarker(markerOptions);

            Log.i("maps", point.toString());

        }
    }


}
