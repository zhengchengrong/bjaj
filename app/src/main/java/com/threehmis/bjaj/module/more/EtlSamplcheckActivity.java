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
import com.threehmis.bjaj.api.bean.request.GetEtlHandcheckReq;
import com.threehmis.bjaj.api.bean.request.GetIcSearchReq;
import com.threehmis.bjaj.api.bean.respon.GetEtlHandCheckRsp;
import com.threehmis.bjaj.api.bean.respon.NameKeyRsp;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//现场见证查验
public class EtlSamplcheckActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout layoutinfo, base;
    boolean isvisiable;
    private ListView infolist;
    private EditText write;

    BaseBeanRsp<GetEtlHandCheckRsp> getEtlHandCheckRsp;
    private ExamReportListAdapter adapter;

    String[] name = {"见证组号", "工程编码", "工程名称", "工程地址", "工程部位", "检测项目"
            , "检测机构", "生产批次", "生产批号", "生产厂家", "试验编号", "样品编码", "备注"};

    String[] key = new String[name.length];
    List<NameKeyRsp> liststr = new ArrayList<>();
    NameKeyRsp nameKeyRsp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampl_check);

        TextView titleback = (TextView) findViewById(R.id.titleback);
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("现场见证查询");

        TextView message = (TextView) findViewById(R.id.message);
        message.setText("现场见证信息");

        write = (EditText) findViewById(R.id.write);
        write.setHint("请输入见证组号或二维码编号");

        layoutinfo = (LinearLayout) findViewById(R.id.layout_info);
        base = (LinearLayout) findViewById(R.id.base);
        infolist = (ListView) findViewById(R.id.infolist);

        TextView scan = (TextView) findViewById(R.id.scan);
        TextView check = (TextView) findViewById(R.id.check);
        TextView btn1 = (TextView) findViewById(R.id.btn1);
        TextView btn2 = (TextView) findViewById(R.id.btn2);
        TextView btn3 = (TextView) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        scan.setOnClickListener(this);
        check.setOnClickListener(this);
        titleback.setOnClickListener(this);


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

            case R.id.scan:

                Intent intent = new Intent(this, QRCodeActivity.class);
                startActivityForResult(intent, 2);

                break;
            case R.id.check://手动查询

                getdate();

                break;
            case R.id.btn1://2.	报告信息
                if (getEtlHandCheckRsp!=null&&getEtlHandCheckRsp.projectList!=null) {
                    Intent intent2 = new Intent(this, ExamReportActivity.class);
//                intent2.putExtra("syNum","JC000B1000203261");
                    intent2.putExtra("syNum", getEtlHandCheckRsp.projectList.get(0).syNum);
                    startActivity(intent2);
                }
                break;
            case R.id.btn2://3.	现场照片

                if (getEtlHandCheckRsp!=null&&getEtlHandCheckRsp.projectList!=null) {
                    Intent intent1 = new Intent(this, GridPicturesActivity.class);
                    intent1.putExtra("id", getEtlHandCheckRsp.projectList.get(0).id);
                    intent1.putExtra("type", "见证图片");
                    startActivity(intent1);
                }

                break;
            case R.id.btn3://4.	地理位置

                Intent intent3 = new Intent(this,MapLocationActivity.class);
                intent3.putExtra("lat",getEtlHandCheckRsp.projectList.get(0).y);
                intent3.putExtra("lon",getEtlHandCheckRsp.projectList.get(0).x);
                startActivity(intent3);
                break;
        }

    }


    private void getdate() {

        if (TextUtils.isEmpty(write.getText().toString())) {
            Toast.makeText(EtlSamplcheckActivity.this, "请输入查询条件!", Toast.LENGTH_SHORT).show();
        }

        GetEtlHandcheckReq req = new GetEtlHandcheckReq();
        req.grouporder = write.getText().toString();

        AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlSamplcheck/findByGrouporder", req, new okhttpcall());
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

            getEtlHandCheckRsp = JSON.parseObject(body, new TypeReference<BaseBeanRsp<GetEtlHandCheckRsp>>() {
            });
            mHandler.sendEmptyMessage(getEtlHandCheckRsp.verification ? GetData.MSG_SUCESS : GetData.MSG_OTHER);
        }
    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case GetData.MSG_SUCESS:

                    key[0] = getEtlHandCheckRsp.projectList.get(0).grouporder;
                    key[1] = getEtlHandCheckRsp.projectList.get(0).projectcode;
                    key[2] = getEtlHandCheckRsp.projectList.get(0).projectname;
                    key[3] = getEtlHandCheckRsp.projectList.get(0).projectaddr;
                    key[4] = getEtlHandCheckRsp.projectList.get(0).projectposition;
                    key[5] = getEtlHandCheckRsp.projectList.get(0).itemname;
                    key[6] = getEtlHandCheckRsp.projectList.get(0).organname;
                    key[7] = getEtlHandCheckRsp.projectList.get(0).productorder;
                    key[8] = getEtlHandCheckRsp.projectList.get(0).productnum;
                    key[9] = getEtlHandCheckRsp.projectList.get(0).productfactory;
                    key[10] = getEtlHandCheckRsp.projectList.get(0).syNum;
                    key[11] = getEtlHandCheckRsp.projectList.get(0).phNum;
                    key[12] = getEtlHandCheckRsp.projectList.get(0).remark;

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

                    break;
                case GetData.MSG_FAIL:

                    Toast.makeText(EtlSamplcheckActivity.this, "获取数据失败!", Toast.LENGTH_SHORT).show();
                    break;
                case GetData.MSG_OTHER:

                    Toast.makeText(EtlSamplcheckActivity.this, "此数据不存在!", Toast.LENGTH_SHORT).show();
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

                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlSamplcheck/findByCode", req, new okhttpcall());

            }
        }
    }


}
