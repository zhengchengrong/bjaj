package com.threehmis.bjaj.module.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.threehmis.bjaj.R;
import com.threehmis.bjaj.adapter.PictureDetailAdapter;
import com.threehmis.bjaj.widget.HackyViewPager;
import com.threehmis.bjaj.widget.photoview.PhotoViewAttacher;

import java.util.ArrayList;

public class PictureDetailActivity extends AppCompatActivity {

    PictureDetailAdapter adapter;
    private FrameLayout txtLayout;
    private HackyViewPager pager;
    TextView edit;
    int position;

    String pictureUrl,checkId,photoId;
    ArrayList<String> pictureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        Bundle bundle = this.getIntent().getExtras();
        pictureUrl = bundle.getString("pictureUrl");
        checkId = bundle.getString("checkId");//查看进来时为null
        photoId = bundle.getString("photoId");//查看进来时为null
        position = bundle.getInt("position",0);
        pictureList = bundle.getStringArrayList("pictureList")!=null?bundle.getStringArrayList("pictureList"):new ArrayList<String>();

        txtLayout = (FrameLayout) findViewById(R.id.txtLayout);
        pager = (HackyViewPager) findViewById(R.id.pager);
        edit = (TextView) findViewById(R.id.edit);

        afterViews();

    }

    private  void afterViews() {

        adapter = new PictureDetailAdapter(new photoTapListener(), this);

        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new pagerChangerListener());

        if(pictureUrl!=null){
            edit.setVisibility(checkId!=null? View.VISIBLE: View.GONE);
            pictureList.add(pictureUrl);
        }


        adapter.addPictureData(pictureList);
        pager.setCurrentItem(position);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击编辑划线
                Intent intent=new Intent(PictureDetailActivity.this,PictureEditActivity.class);
                intent.putExtra("intupUrl",pictureUrl);
                intent.putExtra("checkId",checkId);
                intent.putExtra("photoId",photoId);
                startActivity(intent);
                finish();
            }
        });

    }

    class pagerChangerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
        }

    }

    private class photoTapListener implements PhotoViewAttacher.OnPhotoTapListener {

        @Override
        public void onPhotoTap(View view, float x, float y) {

            txtLayout.setVisibility(txtLayout.isShown() ? View.GONE : View.VISIBLE);
            if (!txtLayout.isShown()) {
                PictureDetailActivity.this.finish();
            }

        }
    }



}
