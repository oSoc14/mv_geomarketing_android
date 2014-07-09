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


    public MyGoogleMapHelper( GoogleMap googleMap ) {
        this.googleMap = googleMap;
        LLOG.logg("MyGoogleMapHelper made");

    }

    public void initializeMap() {
        LLOG.logg("initializeMap()");

        if (googleMap != null) {

            googleMap.setOnMapClickListener(new MyOnClickMapListener(googleMap));
            drawCircle();
            setStaticPoints();

        } else {
            LLOG.logg("googleMap is null");
        }

    }

    public void setLocation(Location location) {

    }

    public void drawCircle() {
        final CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(51.04157350602823,3.726298436522484));
        circleOptions.radius(300);
        circleOptions.strokeColor(R.drawable.purple);
        circleOptions.fillColor(R.drawable.purple);
        final Circle circle = googleMap.addCircle(circleOptions);
    }

    public  void zoomMap(LatLng latLng) {

        //location.getLatitude(), location.getLongitude()

        CameraUpdate center=
        CameraUpdateFactory.newLatLng(latLng);
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(14);

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
            googleMap.addMarker(markerOptions);

        }


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
