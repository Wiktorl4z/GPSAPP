package com.example.l4z.gpsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class KwotaActivity extends AppCompatActivity {


    public static final String KWOTA_KEY = "KWOTA";
    private Kwota kwota;
    private RadioButton dziesiec, dwadziescia, trzydziesci, pieciedziesiat;
    private Button send3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kwota);


        dziesiec = (RadioButton) findViewById(R.id.dziesiec);
        dziesiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        dwadziescia = (RadioButton) findViewById(R.id.dwadziescia);
        dwadziescia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        trzydziesci = (RadioButton) findViewById(R.id.trzydziesci);
        trzydziesci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        pieciedziesiat = (RadioButton) findViewById(R.id.pieciedziesiat);
        pieciedziesiat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        send3 = (Button) findViewById(R.id.send3);
        send3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KwotaActivity.this, MainActivity.class);
                intent.putExtra(KuchniaActivity.KUCHNIA_KEY, getIntent().getSerializableExtra(KuchniaActivity.KUCHNIA_KEY));
                intent.putExtra(KWOTA_KEY, kwota);
                startActivity(intent);

            }
        });
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        if (checked)
            switch (view.getId()) {
                case R.id.dziesiec:
                    kwota = Kwota.K10;
                    break;
                case R.id.dwadziescia:
                    kwota = Kwota.K20;
                    break;
                case R.id.trzydziesci:
                    kwota = Kwota.K30;
                    break;
                case R.id.pieciedziesiat:
                    kwota = Kwota.K50;
                    break;
            }
    }
}