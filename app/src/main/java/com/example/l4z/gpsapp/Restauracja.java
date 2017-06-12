package com.example.l4z.gpsapp;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Restauracja  {

    private String nazwa;
    private double wysokosc;
    private double szerokosc;

    public Restauracja(String nazwa, double szerokosc, double wysokosc ) {
        this.nazwa = nazwa;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
    }

    public MarkerOptions getMarkerOption(){
        return new MarkerOptions()
                .position(new LatLng(szerokosc, wysokosc)).title(nazwa);
    }
}
