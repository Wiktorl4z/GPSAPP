package com.example.l4z.gpsapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    private Kwota kwota;
    private Kuchnia kuchnia;
    private List<Restauracja> restauracjas;
    private GoogleMap m_map;
    boolean mapReady = false;


    static final CameraPosition LUBLIN = CameraPosition.builder()
            .target(new LatLng(51.2348891, 22.5468983))
            .zoom(13)
            .bearing(0)
            .tilt(30)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kwota = (Kwota) getIntent().getSerializableExtra(KwotaActivity.KWOTA_KEY);
        kuchnia = (Kuchnia) getIntent().getSerializableExtra(KuchniaActivity.KUCHNIA_KEY);

        restauracjas = BazaKuchni.getInstance().getRestauracja(kwota, kuchnia);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public void onMapReady(GoogleMap map) {

        mapReady = true;
        m_map = map;
        m_map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(41.889, -87.622), 16));
        for (Restauracja r : restauracjas) {
            m_map.addMarker(r.getMarkerOption());
        }
        flyTo(LUBLIN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Resources getResources() {
        return super.getResources();
    }
}
