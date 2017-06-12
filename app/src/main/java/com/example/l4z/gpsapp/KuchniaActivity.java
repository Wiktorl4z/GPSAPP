package com.example.l4z.gpsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class KuchniaActivity extends AppCompatActivity {

    public static final String KUCHNIA_KEY = "KUCHNIA";
    private Kuchnia kuchnia;
    private RadioButton wloska, polska, bbq, japonska, inna;
    private RadioGroup radioGroup;
    private Button send1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuchnia);


        wloska = (RadioButton) findViewById(R.id.wloska);
        wloska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        polska = (RadioButton) findViewById(R.id.polska);
        polska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        bbq = (RadioButton) findViewById(R.id.bbq);
        bbq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        japonska = (RadioButton) findViewById(R.id.japonska);
        japonska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        inna = (RadioButton) findViewById(R.id.inna);
        inna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        radioGroup = (RadioGroup) findViewById(R.id.radio_group_kuchnia);
        radioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);

            }
        });

        send1 = (Button) findViewById(R.id.send1);
        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KuchniaActivity.this, KwotaActivity.class);
                intent.putExtra(KUCHNIA_KEY, kuchnia);
                startActivity(intent);
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        if (checked)
            switch (view.getId()) {
                case R.id.polska:
                    kuchnia = Kuchnia.POLSKA;
                    break;
                case R.id.wloska:
                    kuchnia = Kuchnia.WLOSKA;
                    break;
                case R.id.bbq:
                    kuchnia = Kuchnia.BBQ;
                    break;
                case R.id.japonska:
                    kuchnia = Kuchnia.JAPONSKA;
                    break;
                case R.id.inna:
                    kuchnia = Kuchnia.INNA;
                    break;
            }
    }
}