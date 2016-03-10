package com.centling.findplayer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.centling.findplayer.R;

public class filtrate extends MainActivity {

    private Button Button_1;
    private Button Button_2;
    private Button Button_3;
    private Button Button_4;
    private Button Button_5;
    private Button Button_6;
    private Button Button_7;
    private Button Button_8;
    private Button Button_9;
    private Button Button_10;
    private Button Button_11;
    private Button Button_12;
    private Button Button_13;
    private Button Button_14;
    private Button Button_15;
    private Button Button_16;
    private Button Button_17;
    private Button Button_18;
    private Button Button_19;
    private Button Button_20;
    private Button Button_21;
    private Button Button_22;
    private Button Button_23;
    private Button Button_24;
    private int buttonGender;
    private int buttonPrice;
    private int buttonGame;
    private int buttonDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_filtrate);
        initDate();
        initGender();
        initGame();
        initPrice();
        initDistance();
        initActivityStatus();
    }

    private void initDate() {
        buttonGender=buttonPrice=buttonGame=buttonDistance=0;
    }
    private void initGender() {
        Button_1 = (Button) findViewById(R.id.Button_1);
        Button_2 = (Button) findViewById(R.id.Button_2);
        Button_3 = (Button) findViewById(R.id.Button_3);
        Button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_1:
                        buttonGender = R.id.Button_1;
                        return;
                    default:
                        break;
                }
            }
        });
        Button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_2:
                        buttonGender = R.id.Button_2;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_3:
                        buttonGender = R.id.Button_3;
                        return;
                    default:
                        break;

                }
            }
        });
    }

    private void initPrice() {
        Button_4 = (Button) findViewById(R.id.Button_4);
        Button_5 = (Button) findViewById(R.id.Button_5);
        Button_6 = (Button) findViewById(R.id.Button_6);
        Button_7 = (Button) findViewById(R.id.Button_7);

        Button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_4:
                        buttonPrice = R.id.Button_4;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_5:
                        buttonPrice = R.id.Button_5;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_6:
                        buttonPrice = R.id.Button_6;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_7:
                        buttonPrice = R.id.Button_7;
                        return;
                    default:
                        break;

                }
            }
        });
    }
    private void initGame() {
        Button_8 = (Button) findViewById(R.id.Button_8);
        Button_9 = (Button) findViewById(R.id.Button_9);
        Button_10 = (Button) findViewById(R.id.Button_10);
        Button_11 = (Button) findViewById(R.id.Button_11);
        Button_12 = (Button) findViewById(R.id.Button_12);
        Button_13 = (Button) findViewById(R.id.Button_13);
        Button_14 = (Button) findViewById(R.id.Button_14);
        Button_15 = (Button) findViewById(R.id.Button_15);
        Button_16 = (Button) findViewById(R.id.Button_16);
        Button_17 = (Button) findViewById(R.id.Button_17);
        Button_18 = (Button) findViewById(R.id.Button_18);
        Button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_8:
                        buttonGame = R.id.Button_8;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_9:
                        buttonGame = R.id.Button_9;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_10:
                        buttonGame = R.id.Button_10;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_11:
                        buttonGame = R.id.Button_11;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_12:
                        buttonGame = R.id.Button_12;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_13:
                        buttonGame = R.id.Button_13;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_14:
                        buttonGame = R.id.Button_14;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_15:
                        buttonGame = R.id.Button_15;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_16:
                        buttonGame = R.id.Button_16;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_17:
                        buttonGame = R.id.Button_17;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_18:
                        buttonGame = R.id.Button_18;
                        return;
                    default:
                        break;

                }
            }
        });
    }
    private void initDistance() {
        Button_19 = (Button) findViewById(R.id.Button_19);
        Button_20 = (Button) findViewById(R.id.Button_20);
        Button_21 = (Button) findViewById(R.id.Button_21);
        Button_22 = (Button) findViewById(R.id.Button_22);
        Button_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_19:
                        buttonDistance = R.id.Button_19;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_20:
                        buttonDistance = R.id.Button_20;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_21:
                        buttonDistance = R.id.Button_21;
                        return;
                    default:
                        break;

                }
            }
        });
        Button_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.Button_22:
                        buttonDistance = R.id.Button_22;
                        return;
                    default:
                        break;

                }
            }
        });
    }

    private void initActivityStatus() {
        Button_23 = (Button) findViewById(R.id.Button_23);
        Button_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Button_23:
                        //back to main_activity
                        break;
                    default:
                        break;
                }
            }
        });
        Button_24 = (Button) findViewById(R.id.Button_24);
        Button_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Button_24:
                        //push the date to background.
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
