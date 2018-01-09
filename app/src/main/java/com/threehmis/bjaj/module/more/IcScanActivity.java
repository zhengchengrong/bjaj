package com.threehmis.bjaj.module.more;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.threehmis.bjaj.AndroidApplication;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.adapter.ExamReportListAdapter;
import com.threehmis.bjaj.api.GetData;
import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.request.GetICEtlSamplReq;
import com.threehmis.bjaj.api.bean.request.GetIcSearchReq;
import com.threehmis.bjaj.api.bean.respon.GetIcSeachRsp;
import com.threehmis.bjaj.api.bean.respon.GetLocationXYRsp;
import com.threehmis.bjaj.api.bean.respon.NameKeyRsp;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class IcScanActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutinfo, base;
    boolean isvisiable;
    private ListView infolist;
    private EditText write;

    BaseBeanRsp<GetIcSeachRsp> getIcSeachRsp;
    BaseBeanRsp<GetLocationXYRsp> getLocationXYRsp;
    private ExamReportListAdapter adapter;

    String[] name = {"工程名称", "监督编号", "硂流水号", "试件编号", "取样部位", "设计强度"
            , "养护条件", "芯片规格", "见证人", "见证证号", "成型时间"};

    String[] key = new String[name.length];

    List<NameKeyRsp> liststr = new ArrayList<>();
    NameKeyRsp nameKeyRsp;
    private boolean ispositionXY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic_scan);

        TextView titleback = (TextView) findViewById(R.id.titleback);
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("现场芯片查询");
        titleback.setOnClickListener(this);

        layoutinfo = (LinearLayout) findViewById(R.id.layout_info);
        base = (LinearLayout) findViewById(R.id.base);
        infolist = (ListView) findViewById(R.id.infolist);
        write = (EditText) findViewById(R.id.write);

        TextView clickscan = (TextView) findViewById(R.id.click_scan);
        TextView check = (TextView) findViewById(R.id.check);
        TextView btn1 = (TextView) findViewById(R.id.btn1);
        TextView btn2 = (TextView) findViewById(R.id.btn2);
        TextView btn3 = (TextView) findViewById(R.id.btn3);
        TextView btn4 = (TextView) findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        clickscan.setOnClickListener(this);
        check.setOnClickListener(this);
        layoutinfo.setVisibility(View.GONE);

        adapter = new ExamReportListAdapter();
        infolist.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.titleback:

                if (isvisiable) {
                    layoutinfo.setVisibility(View.GONE);
                    base.setVisibility(View.VISIBLE);
                    isvisiable = false;
                } else
                    finish();

                break;

            case R.id.click_scan:

                Intent intent = new Intent(this, QRCodeActivity.class);
                startActivityForResult(intent, 2);

                break;
            case R.id.check://手动查询

                getdate();

                break;
            case R.id.btn1://1.	植入照片

                if (getIcSeachRsp!=null&&getIcSeachRsp.projectList!=null) {
                    Intent intent1 = new Intent(this, GridPicturesActivity.class);
                    intent1.putExtra("id", getIcSeachRsp.projectList.get(0).id);
                    intent1.putExtra("type", "芯片植入图片");
                    startActivity(intent1);
                }
                break;
            case R.id.btn2://2.	植入位置

                if (getIcSeachRsp!=null&&getIcSeachRsp.projectList!=null) {

                    getPotodate(getIcSeachRsp.projectList.get(0).id,"芯片植入位置");
                }
                break;
            case R.id.btn3://3.	见证照片

                if (getIcSeachRsp!=null&&getIcSeachRsp.projectList!=null) {
                    Intent intent3 = new Intent(this, GridPicturesActivity.class);
                    intent3.putExtra("id", getIcSeachRsp.projectList.get(0).id);
                    intent3.putExtra("type", "芯片图片");
                    startActivity(intent3);
                }
                break;
            case R.id.btn4://4.	见证位置

                if (getIcSeachRsp!=null&&getIcSeachRsp.projectList!=null) {

                    getPotodate(getIcSeachRsp.projectList.get(0).id,"芯片见证位置");
                }

                break;

        }

    }

    private void getdate() {

        if (TextUtils.isEmpty(write.getText().toString())) {
            Toast.makeText(IcScanActivity.this, "请输入查询条件!", Toast.LENGTH_SHORT).show();
        }

        GetIcSearchReq req = new GetIcSearchReq();
        req.code = write.getText().toString();

        AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlChipset/findByCode", req, new okhttpcall());
    }

    private void getPotodate(String id, String type) {

        ispositionXY = true;
        GetICEtlSamplReq req = new GetICEtlSamplReq();
        req.id = id;

        switch (type){
            case "芯片见证位置":
                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlChipset/findPosition", req, new okhttpcall());
                break;
            case "芯片植入位置":
                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlChipset/findZrposition", req, new okhttpcall());
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

            if (ispositionXY){

                getLocationXYRsp = JSON.parseObject(body, new TypeReference<BaseBeanRsp<GetLocationXYRsp>>() {
                });
                mHandler.sendEmptyMessage(getLocationXYRsp.verification ? GetData.MSG_SUCESS : GetData.MSG_OTHER);
            }else {
                getIcSeachRsp = JSON.parseObject(body, new TypeReference<BaseBeanRsp<GetIcSeachRsp>>() {
                });
                mHandler.sendEmptyMessage(getIcSeachRsp.verification ? GetData.MSG_SUCESS : GetData.MSG_OTHER);
            }
        }
    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case GetData.MSG_SUCESS:

                    if (ispositionXY){

                        Intent intent3 = new Intent(IcScanActivity.this,MapLocationActivity.class);
                        intent3.putExtra("lat",getLocationXYRsp.projectList.get(0).latitude);
                        intent3.putExtra("lon",getLocationXYRsp.projectList.get(0).longitude);
                        startActivity(intent3);


                    }else {


                        key[0] = getIcSeachRsp.projectList.get(0).projectname;
                        key[1] = getIcSeachRsp.projectList.get(0).projectnum;
                        key[2] = getIcSeachRsp.projectList.get(0).hntSeqid;
                        key[3] = getIcSeachRsp.projectList.get(0).phNum;
                        key[4] = getIcSeachRsp.projectList.get(0).qybw;
                        key[5] = getIcSeachRsp.projectList.get(0).sjqd;
                        key[6] = getIcSeachRsp.projectList.get(0).yanghu;
                        key[7] = getIcSeachRsp.projectList.get(0).chipsetsize;
                        key[8] = getIcSeachRsp.projectList.get(0).eyewitness;
                        key[9] = getIcSeachRsp.projectList.get(0).eyewitnesscode;
                        key[10] = getIcSeachRsp.projectList.get(0).cxdate;

                        liststr.clear();
                        for (int i = 0; i < name.length; i++) {
                            nameKeyRsp = new NameKeyRsp();
                            nameKeyRsp.name = name[i];
                            nameKeyRsp.key = key[i];
                            liststr.add(nameKeyRsp);

                        }
                        adapter.adddate(liststr);

                        layoutinfo.setVisibility(View.VISIBLE);
                        base.setVisibility(View.GONE);
                        isvisiable = true;

                    }
                    break;
                case GetData.MSG_FAIL:

                    Toast.makeText(IcScanActivity.this, "获取数据失败!", Toast.LENGTH_SHORT).show();
                    break;
                case GetData.MSG_OTHER:

                    Toast.makeText(IcScanActivity.this, "此数据不存在!", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            //解析B传来的数据

            if (data != null) {
                String result = data.getStringExtra("result");

                GetIcSearchReq req = new GetIcSearchReq();
                req.code = result;

                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlChipset/findByCode", req, new okhttpcall());
            }
        }
    }


}
