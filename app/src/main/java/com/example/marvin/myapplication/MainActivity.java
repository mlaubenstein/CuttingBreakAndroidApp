package com.example.marvin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ButtonNenner = (Button) findViewById(R.id.buttonclearnenner);
        ButtonNenner.setOnClickListener(this);

        Button ButtonZaehler = (Button) findViewById(R.id.buttonclearzaehler);
        ButtonZaehler.setOnClickListener(this);

        Button button = (Button) findViewById(R.id.buttonergebnis);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {



        EditText etZaehler = findViewById(R.id.zaehler);
        EditText etNenner  = findViewById(R.id.nenner);

        String stringZaehler = etZaehler.getText().toString();
        String stringNenner  = etNenner.getText().toString();

        if (stringZaehler.length()==0||stringNenner.length()==0){
            return;
        }

        int zaehlerEingabe = Integer.parseInt(etZaehler.getText().toString());
        int nennerEingabe  = Integer.parseInt(etNenner.getText().toString());


        switch(v.getId()) {
            case R.id.buttonergebnis:


                if (zaehlerEingabe * nennerEingabe != 0) {
                    int rest, ggt, divisor;

                    ggt = Math.abs(zaehlerEingabe);
                    divisor = Math.abs(nennerEingabe);

                    do {
                        rest = ggt % divisor;
                        ggt = divisor;
                        divisor = rest;
                    } while (rest > 0);

                    zaehlerEingabe /= ggt;
                    nennerEingabe /= ggt;

                    etZaehler.setText(Integer.toString(zaehlerEingabe));
                    etNenner.setText(Integer.toString(nennerEingabe));

                }
                break;


            case R.id.buttonclearnenner:
                etNenner.setText("");
                break;

            case R.id.buttonclearzaehler:
                etZaehler.setText("");
                break;
        }
    }

}
