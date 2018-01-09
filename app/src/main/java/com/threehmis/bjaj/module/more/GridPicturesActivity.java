package com.threehmis.bjaj.module.more;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.threehmis.bjaj.AndroidApplication;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.adapter.GridPicturesAdapter;
import com.threehmis.bjaj.api.GetData;
import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.request.GetICEtlSamplReq;
import com.threehmis.bjaj.api.bean.respon.GetIcEtlSamplRsp;


import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GridPicturesActivity extends AppCompatActivity {

    String id,type;
    BaseBeanRsp<GetIcEtlSamplRsp> getIcEtlSamplRsp;
    private GridPicturesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_pictures);

        id =getIntent().getStringExtra("id");
        type =getIntent().getStringExtra("type");

        TextView titleback = (TextView) findViewById(R.id.titleback);
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("照片");

        titleback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        GridView mygridView = (GridView) findViewById(R.id.mygridView);

        adapter = new GridPicturesAdapter();

        mygridView.setAdapter(adapter);

        getPotodate(id,type);

    }

    private void getPotodate(String id, String type) {

        GetICEtlSamplReq req = new GetICEtlSamplReq();
        req.id = id;

        switch (type){
            case "见证图片":
                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlSamplcheck/getAllPhotoId", req, new okhttpcall());
                break;
            case "芯片图片":
                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlChipset/getAllPhotoId", req, new okhttpcall());
                break;
            case "芯片植入图片":
                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlChipset/getAllZrPhotoId", req, new okhttpcall());
                break;

        }

    }

    class okhttpcall implements Callback {


        @Override
        public void onFailure(Call call, IOException e) {

            mHandler.sendEmptyMessage(GetData.MSG_FAIL);
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {

            String body = response.body().string();

            Log.d("CD", "DDDDDDDDDD=" + body);

            getIcEtlSamplRsp = JSON.parseObject(body, new TypeReference<BaseBeanRsp<GetIcEtlSamplRsp>>() {
            });
            mHandler.sendEmptyMessage(getIcEtlSamplRsp.verification ? GetData.MSG_SUCESS : GetData.MSG_OTHER);
        }
    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case GetData.MSG_SUCESS:

                    ArrayList<String> pictureList = new ArrayList<String>();
                    switch (type){
                        case "见证图片":

                            for(int i =0;i< getIcEtlSamplRsp.projectList.size();i++) {
                                pictureList.add(GetData.morenurl + "etlSamplcheck/lookPhoto/" + getIcEtlSamplRsp.projectList.get(i).id);
                            }
                            break;
                        case "芯片图片":

                            for(int i =0;i< getIcEtlSamplRsp.projectList.size();i++) {
                                pictureList.add(GetData.morenurl + "etlChipset/lookPhoto/" + getIcEtlSamplRsp.projectList.get(i).id);
                            }
                            break;
                        case "芯片植入图片":

                            for(int i =0;i< getIcEtlSamplRsp.projectList.size();i++) {
                                pictureList.add(GetData.morenurl + "etlChipset/lookZrPhoto/" + getIcEtlSamplRsp.projectList.get(i).id);
                            }
                            break;

                    }

                    adapter.DateNotify(pictureList);

                    break;
                case GetData.MSG_FAIL:

                    Toast.makeText(GridPicturesActivity.this, "获取数据失败!", Toast.LENGTH_SHORT).show();
                    break;
                case GetData.MSG_OTHER:

                    Toast.makeText(GridPicturesActivity.this, "此数据不存在!", Toast.LENGTH_SHORT).show();
                    break;

                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();

        mHandler.removeCallbacksAndMessages(null);
    }

}
