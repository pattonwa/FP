package com.centling.findplayer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FiltrateActivity extends Activity {

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
    private TextView back;
    private TextView done;
    private int buttonGender;
    private int buttonPrice;
    private int buttonGame;
    private int buttonDistance;
    private myOnClickListener localListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
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
        localListener = new myOnClickListener();
    }
    private void initGender() {
        Button_1 = (Button) findViewById(R.id.Button_1);
        Button_2 = (Button) findViewById(R.id.Button_2);
        Button_3 = (Button) findViewById(R.id.Button_3);
        Button_1.setOnClickListener(localListener);
        Button_2.setOnClickListener(localListener);
        Button_3.setOnClickListener(localListener);
    }

    private void initPrice() {
        Button_4 = (Button) findViewById(R.id.Button_4);
        Button_5 = (Button) findViewById(R.id.Button_5);
        Button_6 = (Button) findViewById(R.id.Button_6);
        Button_7 = (Button) findViewById(R.id.Button_7);

        Button_4.setOnClickListener(localListener);
        Button_5.setOnClickListener(localListener);
        Button_6.setOnClickListener(localListener);
        Button_7.setOnClickListener(localListener);
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
        Button_8.setOnClickListener(localListener);
        Button_9.setOnClickListener(localListener);
        Button_10.setOnClickListener(localListener);
        Button_11.setOnClickListener(localListener);
        Button_12.setOnClickListener(localListener);
        Button_13.setOnClickListener(localListener);
        Button_14.setOnClickListener(localListener);
        Button_15.setOnClickListener(localListener);
        Button_16.setOnClickListener(localListener);
        Button_17.setOnClickListener(localListener);
        Button_18.setOnClickListener(localListener);
    }
    private void initDistance() {
        Button_19 = (Button) findViewById(R.id.Button_19);
        Button_20 = (Button) findViewById(R.id.Button_20);
        Button_21 = (Button) findViewById(R.id.Button_21);
        Button_22 = (Button) findViewById(R.id.Button_22);
        Button_19.setOnClickListener(localListener);
        Button_20.setOnClickListener(localListener);
        Button_21.setOnClickListener(localListener);
        Button_22.setOnClickListener(localListener);
    }
    private void initActivityStatus() {
        back = (TextView) findViewById(R.id.back);
        back.setOnClickListener(localListener);
        done = (TextView) findViewById(R.id.done);
        done.setOnClickListener(localListener);
    }

    private class myOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.done:
                    //push the date to background.
                    Toast.makeText(FiltrateActivity.this, "Cllick on done", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.back:
                    //back to main_activity
                    break;
                case R.id.Button_22:
                    buttonDistance = R.id.Button_22;
                    break;
                case R.id.Button_21:
                    buttonDistance = R.id.Button_21;
                    break;
                case R.id.Button_20:
                    buttonDistance = R.id.Button_20;
                    break;
                case R.id.Button_19:
                    buttonDistance = R.id.Button_19;
                    break;
                case R.id.Button_18:
                    buttonGame = R.id.Button_18;
                    break;
                case R.id.Button_17:
                    buttonGame = R.id.Button_17;
                    break;
                case R.id.Button_16:
                    buttonGame = R.id.Button_16;
                    break;
                case R.id.Button_15:
                    buttonGame = R.id.Button_15;
                    break;
                case R.id.Button_14:
                    buttonGame = R.id.Button_14;
                    break;
                case R.id.Button_13:
                    buttonGame = R.id.Button_13;
                    break;
                case R.id.Button_12:
                    buttonGame = R.id.Button_12;
                    break;
                case R.id.Button_11:
                    buttonGame = R.id.Button_11;
                    break;
                case R.id.Button_10:
                    buttonGame = R.id.Button_10;
                    break;
                case R.id.Button_9:
                    buttonGame = R.id.Button_9;
                    break;
                case R.id.Button_8:
                    buttonGame = R.id.Button_8;
                    break;
                case R.id.Button_7:
                    buttonPrice = R.id.Button_7;
                    break;
                case R.id.Button_6:
                    buttonPrice = R.id.Button_6;
                    break;
                case R.id.Button_5:
                    buttonPrice = R.id.Button_5;
                    break;
                case R.id.Button_4:
                    buttonPrice = R.id.Button_4;
                    break;
                case R.id.Button_3:
                    buttonGender = R.id.Button_3;
                    break;
                case R.id.Button_2:
                    buttonGender = R.id.Button_2;
                    break;
                case R.id.Button_1:
                    buttonGender = R.id.Button_1;
                    break;
                default:
                    break;
            }
        }
    }

}
