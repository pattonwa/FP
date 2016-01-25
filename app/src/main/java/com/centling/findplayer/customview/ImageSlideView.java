package com.centling.findplayer.customview;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.centling.findplayer.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Created by pattonwa on 2016/1/14.
 */
public class ImageSlideView extends FrameLayout{
    private final String TAG = "ImageSlideView";
    private Context context;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private List<ImageView> imageViewList;
    private List<View> dotViewsList;
    private String[] imageUrls;
    private final static boolean isAutoPlay = true;
    private ScheduledExecutorService scheduledExecutorService;
    private ViewPager viewPager;
    private int currentItem = 0;
    private Handler handler = new Handler(){
        @Override
        public  void handleMessage(Message msg){
            super.handleMessage(msg);
            Log.v(TAG, "handler set the image");
            viewPager.setCurrentItem(currentItem);
        }
    };

    public ImageSlideView(Context context){
        this(context, null);
    }
    public ImageSlideView(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }
    public ImageSlideView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        this.context = context;
        initImageLoader(context);
        initData();

        if(isAutoPlay){
            Log.d(TAG,"auto play to start");
            startPlay();
        }
    }

    private void startPlay(){
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new SlideShowTask(), 1, 4, TimeUnit.SECONDS);
    }

    private void stopPlay(){
        scheduledExecutorService.shutdown();
    }

    private class SlideShowTask implements Runnable{
        @Override
        public void run(){
            synchronized (viewPager){
                currentItem = (currentItem+1) % imageViewList.size();
                handler.obtainMessage().sendToTarget();
            }
        }
    }

    public static void initImageLoader(Context context){
        ImageLoaderConfiguration imgConfig = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY).build();
        ImageLoader.getInstance().init(imgConfig);
    }

    private void initData(){
        imageViewList = new ArrayList<ImageView>();
        dotViewsList = new ArrayList<View>();
        new GetListTask().execute("");
    }

    class GetListTask extends AsyncTask<String, Integer, Boolean>{
        @Override
        protected Boolean doInBackground(String... params){
            try {
                imageUrls = new String[]{
                        "http://image.zcool.com.cn/56/35/1303967876491.jpg",
                        "http://image.zcool.com.cn/59/54/m_1303967870670.jpg",
                        "http://image.zcool.com.cn/47/19/1280115949992.jpg",
                        "http://image.zcool.com.cn/59/11/m_1303967844788.jpg"
                };
                return true;
            }catch ( Exception e){
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result){
            super.onPostExecute(result);
            if(result){
                initUI(context);
            }
        }
    }
    private void initUI(Context context){
        if(imageUrls == null || imageUrls.length == 0){
            Log.e(TAG, "There is no image urls");
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.image_slide_box,this,true);
        LinearLayout dotLayout = (LinearLayout)findViewById(R.id.imageIndic);
        dotLayout.removeAllViews();

        for (int imgIndex = 0; imgIndex < imageUrls.length; imgIndex++){
            ImageView view = new ImageView(context);
            view.setTag(imageUrls[imgIndex]);
            switch (imgIndex){
                case 0:
                    view.setBackgroundResource(R.drawable.image_slide_default);
                    break;
                case 1:
                    view.setImageResource(R.drawable.tmp1);
                    break;
                case 2:
                    view.setImageResource(R.drawable.tmp2);
                    break;
                case 3:
                    view.setImageResource(R.drawable.tmp3);
                    break;
                default:
                    view.setImageResource(R.drawable.tmp4);
                    break;
            }
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViewList.add(view);

            ImageView dotView = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.leftMargin = 4;
            params.rightMargin = 4;
            dotLayout.addView(dotView, params);
            dotView.setTag(imgIndex);
            dotView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem((int)v.getTag());
                }
            });
            dotViewsList.add(dotView);
        }
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setFocusable(true);
        viewPager.setAdapter(new MyPagerAdaper());
        viewPager.setOnPageChangeListener(new MyPageChangeListener());
    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener{
        boolean isManual = false;

        @Override
        public void onPageScrollStateChanged(int arg0){
            switch (arg0){
                case 1:   //scrolling
                    isManual = true;
                    break;
                case 2:  //switching page
                    isManual = false;
                    break;
                case 0: //done
                    if(viewPager.getCurrentItem() == viewPager.getAdapter().getCount()-1 && isManual){
                        viewPager.setCurrentItem(0);
                    }
                    else if(viewPager.getCurrentItem() == 0 && isManual){
                        viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 1);
                    }
                    break;
            }
        }

        @Override
        public void onPageSelected(int pos){
            currentItem = pos;
            for(int i=0; i < dotViewsList.size(); i++){
                if (i == pos){
                    ((View)dotViewsList.get(i)).setBackgroundResource(R.drawable.dot_on);
                }else{
                    ((View)dotViewsList.get(i)).setBackgroundResource(R.drawable.dot_off);
                }
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2){
            // TODO
        }

    }

    private class MyPagerAdaper extends PagerAdapter{
        @Override
        public void destroyItem(View container, int position, Object object){
            ((ViewPager)container).removeView(imageViewList.get(position));
        }

        @Override
        public Object instantiateItem(View container, int position){
            ImageView imageView = imageViewList.get(position);
//            imageLoader.displayImage(imageView.getTag() + "", imageView);
            ((ViewPager)container).addView(imageView);
            return imageView;
        }

        @Override
        public int getCount(){
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1){
            return arg0 == arg1;
        }
    }
}
