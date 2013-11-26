package com.pezbailarin.fedrus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CountryDetailActivity extends FragmentActivity {
    public static final String COUNTRY="country";
    private String country="";

    /**
    * Ejecutada al crearse la actividad
    */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Intent i=getIntent();
        country=i.getStringExtra(COUNTRY);
    }


    /**
    * getter para poder acceder al país desde otra actividad
    */
    public String getCountry() {
        return country;
    }
}
