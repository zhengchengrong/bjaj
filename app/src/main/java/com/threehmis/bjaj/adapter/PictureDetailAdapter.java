package com.threehmis.bjaj.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ydzf.hhh.hhh_ydzf.R;
import com.ydzf.hhh.hhh_ydzf.photoview.PhotoView;
import com.ydzf.hhh.hhh_ydzf.photoview.PhotoViewAttacher.OnPhotoTapListener;

import java.util.ArrayList;

public class PictureDetailAdapter extends PagerAdapter {


    ArrayList<String> pictureList = new ArrayList<String>();

    OnPhotoTapListener listener;

    Activity activity;


    public PictureDetailAdapter(OnPhotoTapListener listener, Activity activity) {
        this.listener = listener;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return pictureList.size();
    }

    public String getitem(int position) {

        return pictureList.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        PhotoView photoView = new PhotoView(container.getContext());

        photoView.setOnPhotoTapListener(listener);

        Glide.with(activity).load(pictureList.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.t_pic).into(photoView);

        ((ViewPager) container).addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }


    public void addPictureData(ArrayList<String> pictureList) {

        this.pictureList = pictureList;

        notifyDataSetChanged();

    }

}
