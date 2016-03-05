package com.centling.findplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DateGodFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DateGodFragment extends Fragment {
    private final String TAG = "DateGodFragment";
    private OnFragmentInteractionListener mListener;
    private Activity dateGodAct;

    private RelativeLayout sexOpt;
    private RelativeLayout gameOpt;
    private RelativeLayout startOpt;
    private RelativeLayout durOpt;
    private RelativeLayout locOpt;
    private RelativeLayout priceOpt;

    private TextView sexValue;
    private TextView gameValue;
    private TextView startValue;
    private TextView durValue;
    private EditText etDur;
    private TextView locValue;
    private EditText etLoc;
    private TextView priceValue;
    private EditText etPrice;

    private final String[] sexArray = new String[]{"男", "女"};
    private ArrayList<String> gameArray = new ArrayList<String>();

    private String sex = "";
    private String game = "";
    private String startTime = "";
    private String startTimeBegin = "";
    private String startTimeEnd = "";
    private String duration = "";
    private String location = "";
    private String price = "";

    private Dialog sexDialog;
    private Dialog gameDialog;
    private TimePickerDialog startBeginDialog;
    private TimePickerDialog startEndDialog;
    private Dialog durDialog;
    private Dialog locDialog;
    private Dialog priceDialog;

    private Button btnRel;

    View.OnClickListener optListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.dg_opt_sex:
                    sexDialog.show();
                    break;
                case R.id.dg_opt_game:
                    gameDialog.show();
                    break;
                case R.id.dg_opt_start:
                    startEndDialog.show();
                    startBeginDialog.show();
                    break;
                case R.id.dg_opt_dur:
                    durDialog.show();
                    break;
                case R.id.dg_opt_loc:
                    locDialog.show();
                    break;
                case R.id.dg_opt_price:
                    priceDialog.show();
                    break;
                case R.id.dg_btn_rel:
                    Log.d(TAG, "I am here!");
                    if (sex.isEmpty() || game.isEmpty() || startTime.isEmpty() || duration.isEmpty() || location.isEmpty() || price.isEmpty()){
                        Toast.makeText(dateGodAct, "Please fill all these items!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(dateGodAct, "release all these info", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
    //initial the sex dialog
    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(dialog.equals(sexDialog)) {
                sex = sexArray[which];
                sexValue.setText(sex);
                dialog.dismiss();
            }else if(dialog.equals(gameDialog)){
                game = gameArray.get(which);
                gameValue.setText(game);
                dialog.dismiss();
            }else if(dialog.equals(durDialog)){
                duration = etDur.getText().toString();
                if (!isNumeric(duration)){
                    Toast.makeText(getActivity(), "Only number is allowed", Toast.LENGTH_LONG).show();
                    return;
                }
                durValue.setText(duration + "小时");
                dialog.dismiss();
            }else if (dialog.equals(locDialog)){
                location = etLoc.getText().toString();
                locValue.setText(location);
                dialog.dismiss();
            }else if (dialog.equals(priceDialog)){
                price = etPrice.getText().toString();
                if (!isNumeric(price)){
                    Toast.makeText(getActivity(), "Only number is allowed!", Toast.LENGTH_LONG).show();
                    return;
                }
                priceValue.setText(price + "元/小时");
                dialog.dismiss();
            }
        }
    };
    public DateGodFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_god, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        dateGodAct = getActivity();

        //initial game option
        gameOpt = (RelativeLayout)getActivity().findViewById(R.id.dg_opt_game);
        gameOpt.setOnClickListener(optListener);
        gameValue = (TextView)getActivity().findViewById(R.id.dg_game_value);
        for (int i = 0; i < 5; i++) {
            gameArray.add("英雄联盟");
            gameArray.add("DOTA2");
            gameArray.add("圣域三国");
            gameArray.add("魔兽世界");
            gameArray.add("剑灵");
        }
        gameDialog = new AlertDialog.Builder(getActivity())
                .setTitle("游戏类别")
                .setSingleChoiceItems(gameArray.toArray(new String[gameArray.size()]), 0, dialogListener).create();
        //initial sex option
        sexOpt = (RelativeLayout)getActivity().findViewById(R.id.dg_opt_sex);
        sexOpt.setOnClickListener(optListener);
        sexValue = (TextView)getActivity().findViewById(R.id.dg_sex_value);
        sexDialog = new AlertDialog.Builder(getActivity())
                .setTitle("游神性别")
                .setSingleChoiceItems(sexArray, 0, dialogListener).create();

        //initial start time option
        startOpt = (RelativeLayout)getActivity().findViewById(R.id.dg_opt_start);
        startOpt.setOnClickListener(optListener);
        startValue = (TextView)getActivity().findViewById(R.id.dg_start_value);
        Calendar dateAndTime = Calendar.getInstance();

        startBeginDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay ,int minOfDay){
                startTimeBegin = String.valueOf(hourOfDay) + ":" + String.valueOf(minOfDay) + "-";
            }
        }, dateAndTime.get(Calendar.HOUR_OF_DAY),dateAndTime.get(Calendar.MINUTE), true);
        startBeginDialog.setTitle("最早开始时间");

        startEndDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minOfDay){
                startTimeEnd = String.valueOf(hourOfDay) + ":" + String.valueOf(minOfDay);
                startTime = startTimeBegin.concat(startTimeEnd);
                startValue.setText(startTime);
            }
        }, dateAndTime.get(Calendar.HOUR_OF_DAY), dateAndTime.get(Calendar.MINUTE), true);
        startEndDialog.setTitle("最晚开始时间");

        //initial duration option
        durOpt = (RelativeLayout)getActivity().findViewById(R.id.dg_opt_dur);
        durOpt.setOnClickListener(optListener);
        etDur = new EditText(getActivity());
        durValue = (TextView)getActivity().findViewById(R.id.dg_dur_value);
        durDialog = new AlertDialog.Builder(getActivity())
                .setTitle("陪玩时长（小时）")
                .setView(etDur)
                .setPositiveButton("确定", dialogListener).create();

        //initial location option
        locOpt = (RelativeLayout)getActivity().findViewById(R.id.dg_opt_loc);
        locOpt.setOnClickListener(optListener);
        etLoc = new EditText(dateGodAct);
        locValue = (TextView)dateGodAct.findViewById(R.id.dg_loc_value);
        locDialog = new AlertDialog.Builder(dateGodAct)
                .setTitle("陪玩地点")
                .setView(etLoc)
                .setPositiveButton("确定", dialogListener).create();

        //initial price option
        priceOpt = (RelativeLayout)getActivity().findViewById(R.id.dg_opt_price);
        priceOpt.setOnClickListener(optListener);
        etPrice = new EditText(dateGodAct);
        priceValue = (TextView)dateGodAct.findViewById(R.id.dg_price_value);
        priceDialog = new AlertDialog.Builder(dateGodAct)
                .setTitle("陪玩单价(元/小时)")
                .setView(etPrice)
                .setPositiveButton("确定", dialogListener).create();

        //initial button release
        btnRel = (Button)dateGodAct.findViewById(R.id.dg_btn_rel);
        btnRel.setOnClickListener(optListener);
    }

    private boolean isNumeric(String num){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(num);
        return isNum.matches();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
