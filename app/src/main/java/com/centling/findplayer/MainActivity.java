package com.centling.findplayer;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class MainActivity extends Activity implements View.OnClickListener{
    private String TAG = "MainActivity";
    private LinearLayout tabGameGod;
    private LinearLayout tabExplore;
    private LinearLayout tabMessage;
    private LinearLayout tabMine;
    private LinearLayout tabDateGod;

    private ImageView ivGameGod;
    private ImageView ivExplore;
    private ImageView ivMessage;
    private ImageView ivMine;
    private ImageView ivDateGod;

    private GameGodFragment fgGameGod;
    private ExploreFragment fgExplore;
    private MessageFragment fgMessage;
    private MineFragment fgMine;
    private DateGodFragment fgDateGod;
    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initial tab linearLayout
        tabGameGod = (LinearLayout)findViewById(R.id.tab_game_god);
        tabExplore = (LinearLayout)findViewById(R.id.tab_explore);
        tabMessage = (LinearLayout)findViewById(R.id.tab_message);
        tabMine = (LinearLayout)findViewById(R.id.tab_mine);
        tabDateGod = (LinearLayout)findViewById(R.id.tab_date_god);

        tabGameGod.setOnClickListener(this);
        tabExplore.setOnClickListener(this);
        tabMessage.setOnClickListener(this);
        tabMine.setOnClickListener(this);
        tabDateGod.setOnClickListener(this);

        //initial image view
        ivGameGod = (ImageView)findViewById(R.id.iv_game_god);
        ivExplore = (ImageView)findViewById(R.id.iv_explore);
        ivMessage = (ImageView)findViewById(R.id.iv_message);
        ivMine = (ImageView)findViewById(R.id.iv_mine);
        ivDateGod = (ImageView)findViewById(R.id.iv_date_god);

        //set default fragment
        fm = getFragmentManager();
        fgGameGod = new GameGodFragment();
        setFragment(fgGameGod);
    }

    public void onClick(View v) {
        initTabs();
        switch (v.getId()) {
            case R.id.tab_game_god:
                ivGameGod.setImageResource(R.drawable.game_god_on);
                setFragment(fgGameGod);
                break;
            case R.id.tab_explore:
                if(fgExplore == null){
                    fgExplore = new ExploreFragment();
                }
                ivExplore.setImageResource(R.drawable.explore_on);
                setFragment(fgExplore);
                break;
            case R.id.tab_message:
                if(fgMessage == null){
                    fgMessage = new MessageFragment();
                }
                ivMessage.setImageResource(R.drawable.message_on);
                setFragment(fgMessage);
                break;
            case R.id.tab_mine:
                if(fgMine == null){
                    fgMine = new MineFragment();
                }
                ivMine.setImageResource(R.drawable.mine_on);
                setFragment(fgMine);
                break;
            case R.id.tab_date_god:
                if(fgDateGod == null){
                    fgDateGod = new DateGodFragment();
                }
                ivDateGod.setImageResource(R.drawable.date_god_on);
                setFragment(fgDateGod);
                break;
            default:
                    Log.e(TAG, "Wrong tab id is received");
        }
    }

    private void setFragment(Fragment newFg){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, newFg);
        ft.commit();
    }

    private void initTabs(){
        ivGameGod.setImageResource(R.drawable.game_god);
        ivExplore.setImageResource(R.drawable.explore);
        ivMessage.setImageResource(R.drawable.message);
        ivMine.setImageResource(R.drawable.mine);
        ivDateGod.setImageResource(R.drawable.date_god);
    }

}
