package com.centling.findplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameGodFragment extends Fragment {
    private final String TAG = "GameGodFragment";
    private final String itemPlayerIcon = "player_icon";
    private final String itemPlayerName = "player_name";
    private final String itemPlayerAge = "player_age";
    private final String itemPlayerSex = "player_sex";
    private final String itemPlayerPositionTime = "player_position_time";
    private final String itemPlayerComment = "player_comment";
    private final String itemPlayerOrder = "player_order";
    private final int animationDurTime = 200;


    private TextView subTabSynthesis;
    private TextView subTabHot;
    private TextView subTabFreshman;
    private ImageView subTabCursor;
    private ListView listViewSynthesis;
    private ListView listViewHot;
    private ListView listViewFreshman;

    private List<View> playerList = new ArrayList<View>();
    private ViewPager viewPager;
    private int currentSubTab = 0;
    Animation animation;
    private int offset;
    private int subTabCursorWidth;
    private int subTabSynthesisPos;
    private int subTabHotPos;
    private int subTabFreshmanPos;
    private Bitmap cursor;
    private Matrix matrix = new Matrix();

    private int listViewSynthesisId;
    private int listViewHotId;
    private int listViewFreshmanId;

    private EditText boxSearch;
    private ImageView btnSearchEmpty;

    public GameGodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_god, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //initial search box
        boxSearch = (EditText)getActivity().findViewById(R.id.box_search);
        boxSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    btnSearchEmpty.setVisibility(View.GONE);
                } else {
                    btnSearchEmpty.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSearchEmpty = (ImageView)getActivity().findViewById(R.id.btn_search_empty);
        btnSearchEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boxSearch.setText("");
            }
        });

        //initial palyer list
        subTabSynthesis = (TextView)getActivity().findViewById(R.id.sub_tab_synthesis);
        subTabHot = (TextView)getActivity().findViewById(R.id.sub_tab_hot);
        subTabFreshman = (TextView)getActivity().findViewById(R.id.sub_tab_freshman);
        subTabCursor = (ImageView)getActivity().findViewById(R.id.sub_tab_cursor);

        listViewSynthesis = new ListView(getActivity());
        listViewSynthesisId = listViewSynthesis.generateViewId();
        listViewSynthesis.setId(listViewSynthesisId);
        initialListView(listViewSynthesis);

        listViewHot = new ListView(getActivity());
        listViewHotId = listViewHot.generateViewId();
        listViewHot.setId(listViewHotId);
        initialListView(listViewHot);

        listViewFreshman = new ListView(getActivity());
        listViewFreshmanId = listViewFreshman.generateViewId();
        listViewFreshman.setId(listViewFreshmanId);
        initialListView(listViewFreshman);

        playerList.add(listViewSynthesis);
        playerList.add(listViewHot);
        playerList.add(listViewFreshman);

        viewPager = (ViewPager)getActivity().findViewById(R.id.player_list);
        viewPager.setAdapter(new PlayerListAdapter(playerList));
        initSubTabCursor();
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                switch (arg0) {
                    case 0:
                        if (currentSubTab == 1) {
                            animation = new TranslateAnimation(subTabHotPos, subTabSynthesisPos, 0, 0);
                        } else if (currentSubTab == 2) {
                            animation = new TranslateAnimation(subTabFreshmanPos, subTabSynthesisPos, 0, 0);
                        }
                        break;
                    case 1:
                        if (currentSubTab == 0) {
                            animation = new TranslateAnimation(subTabSynthesisPos, subTabHotPos, 0, 0);
                        } else if (currentSubTab == 2) {
                            animation = new TranslateAnimation(subTabFreshmanPos, subTabHotPos, 0, 0);
                        }
                        break;
                    case 2:
                        if (currentSubTab == 0) {
                            animation = new TranslateAnimation(subTabSynthesisPos, subTabFreshmanPos, 0, 0);
                        } else if (currentSubTab == 1) {
                            animation = new TranslateAnimation(subTabHotPos, subTabFreshmanPos, 0, 0);
                        }
                }
                currentSubTab = arg0;
                animation.setDuration(animationDurTime);
                animation.setFillAfter(true);
                subTabCursor.startAnimation(animation);
            }
        });
        subTabSynthesis.setOnClickListener(new SubTabOnClickListener());
        subTabHot.setOnClickListener(new SubTabOnClickListener());
        subTabFreshman.setOnClickListener(new SubTabOnClickListener());

    }

    private class SubTabOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.sub_tab_synthesis:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.sub_tab_hot:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.sub_tab_freshman:
                    viewPager.setCurrentItem(2);
                    break;
                default:
                    Log.e(TAG, "Wrong sub tab id");
            }

        }
    }

    private void initSubTabCursor(){
        cursor = BitmapFactory.decodeResource(getResources(), R.drawable.tab_cursor);
        subTabCursorWidth = cursor.getWidth();
        Log.d(TAG, "" + subTabCursorWidth);
        DisplayMetrics dm;
        dm = getResources().getDisplayMetrics();
        Log.d(TAG, ""+dm);
        offset = (dm.widthPixels - 3 * subTabCursorWidth) / 6;
        matrix.setTranslate(offset,0);
        subTabCursor.setImageMatrix(matrix);
        currentSubTab = 0;
        subTabSynthesisPos = 0;
        subTabHotPos = offset * 2 + subTabCursorWidth;
        subTabFreshmanPos = offset * 4 + subTabCursorWidth * 2;
    }
    private class PlayerListAdapter extends PagerAdapter{
        List<View> playerList;

        public PlayerListAdapter(List<View> playerList){
            this.playerList = playerList;
        }

        @Override
        public  int getCount(){
            return playerList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1){
            return  arg0 == arg1;
        }

        @Override
        public void destroyItem(View view, int position, Object object){
            ((ViewPager)view).removeView(playerList.get(position));
        }

        @Override
        public  Object instantiateItem(View view, int position){
            ((ViewPager)view).addView(playerList.get(position), 0);
            return playerList.get(position);
        }

    }
    private void initialListView(ListView lv){
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
        for(int i=0; i < 10; i++){
            HashMap<String, Object> item = new HashMap<String, Object>();
            if (lv.getId() == listViewSynthesisId){
                item.put(itemPlayerIcon, R.drawable.tmp_player1);
            }else if (lv.getId() == listViewFreshmanId){
                item.put(itemPlayerIcon, R.drawable.tmp_player2);
            }else {
                item.put(itemPlayerIcon, R.drawable.tmp_player3);
            }
            item.put(itemPlayerName, "Name");
            item.put(itemPlayerAge, "11");
            item.put(itemPlayerSex, "女性");

            item.put(itemPlayerPositionTime, "3.1千米|1分钟前");
            item.put(itemPlayerComment, "好评数:357");
            item.put(itemPlayerOrder, "订单数:20");
            itemList.add(item);
        }
        String[] from = {itemPlayerIcon, itemPlayerName, itemPlayerAge, itemPlayerSex, itemPlayerPositionTime, itemPlayerComment, itemPlayerOrder};
        int[] to = {R.id.player_icon, R.id.player_name, R.id.player_age, R.id.player_sex, R.id.player_position_time, R.id.player_comment, R.id.player_order};
        SimpleAdapter sa = new SimpleAdapter(getActivity(), itemList, R.layout.player_list_layout, from, to);
        lv.setAdapter(sa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getActivity().setTitle("you click on " + position + "!");
            }
        });
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
