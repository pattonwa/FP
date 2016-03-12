package com.centling.findplayer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PlayerDetailInfoActivity extends Activity {

    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail_info);
        mInflater = LayoutInflater.from(this);
        Bundle playerInfo = this.getIntent().getExtras();
        String playerName = playerInfo.getString("name");
        initData();
        initView();
        initUserStatus();
    }

    private void initData()
    {
        mImgIds = new int[] { R.drawable.a, R.drawable.b, R.drawable.c,
                R.drawable.d };
    }

    private void initView()
    {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.length; i++)
        {

            View view = mInflater.inflate(R.layout.activity_pdinfo_image_view,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.imageView);
            img.setImageResource(mImgIds[i]);
            mGallery.addView(view);
        }
    }

    private void initUserStatus()
    {
        ImageView img = (ImageView)findViewById(R.id.userStatus);
        img.setImageResource(mImgIds[0]);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
