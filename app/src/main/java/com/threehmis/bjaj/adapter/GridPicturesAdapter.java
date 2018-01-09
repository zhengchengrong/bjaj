package com.threehmis.bjaj.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.threehmis.bjaj.AndroidApplication;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.module.more.PictureDetailActivity;
import com.threehmis.bjaj.utils.VHUtil;


import java.util.ArrayList;

/**
 * Created by 3hcd on 2017/2/28.
 */

public class GridPicturesAdapter extends BaseAdapter {

    ArrayList<String> str = new ArrayList<>();



    @Override
    public int getCount() {
        return str.size();
    }

    @Override
    public String getItem(int i) {
        return str.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup viewGroup) {

        if (convertView==null)
            convertView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_grid_picture_item,null);

        ImageView img = VHUtil.ViewHolder.get(convertView, R.id.img);
        Glide.with(AndroidApplication.getInstance().getApplicationContext()).load(str.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.t_pic).centerCrop().into(img);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //查看图片
                Intent intent3 = new Intent(viewGroup.getContext(), PictureDetailActivity.class);
//              intent3.putExtra("pictureUrl", GetData.url + "etlSamplcheck/lookPhoto/" + str.get(position).id);
                intent3.putExtra("position", position);
                intent3.putStringArrayListExtra("pictureList",str);
                viewGroup.getContext().startActivity(intent3);
            }
        });


        return convertView;
    }

    public void DateNotify(ArrayList<String> str){
        this.str=str;

        Log.d("cd","str="+ JSON.toJSONString(str));
        notifyDataSetChanged();

    }


}
