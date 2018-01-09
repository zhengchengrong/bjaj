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
import com.threehmis.bjaj.api.bean.request.GetExamReportReq;
import com.threehmis.bjaj.api.bean.respon.GetExamReportRsp;
import com.threehmis.bjaj.api.bean.respon.NameKeyRsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//检测报告查验
public class ExamReportActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutinfo, base;
    boolean isvisiable;
    private ListView infolist;
    private EditText write;

    BaseBeanRsp<GetExamReportRsp> getExamReportRsp;
    private ExamReportListAdapter adapter;

    String[] name = {"报告标识号", "检测项目", "检测机构", "监督登记号", "工程名称", "样品编码"
            , "报告编码", "报告时间", "委托单位", "结论标示", "结论", "上传时间"};

    String[] key = new String[name.length];
    List<NameKeyRsp> liststr = new ArrayList<>();
    NameKeyRsp nameKeyRsp;

    //见证内部报告
    private String syNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_report);

        Intent intent = this.getIntent();
        syNum = intent.getStringExtra("syNum")!=null?intent.getStringExtra("syNum"):"";

        TextView titleback = (TextView) findViewById(R.id.titleback);
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("检测报告查验");

        TextView message = (TextView) findViewById(R.id.message);
        message.setText("检测报告信息");


        write = (EditText) findViewById(R.id.write);
        write.setHint("请输入报告标示号");

        layoutinfo = (LinearLayout) findViewById(R.id.layout_info);
        base = (LinearLayout) findViewById(R.id.base);
        infolist = (ListView) findViewById(R.id.infolist);

        TextView scan = (TextView) findViewById(R.id.scan);
        TextView check = (TextView) findViewById(R.id.check);
        scan.setOnClickListener(this);
        check.setOnClickListener(this);
        titleback.setOnClickListener(this);

        layoutinfo.setVisibility(View.GONE);
        adapter = new ExamReportListAdapter();
        infolist.setAdapter(adapter);

        if (syNum.length()>0){
            layoutinfo.setVisibility(View.VISIBLE);
            base.setVisibility(View.GONE);
            GetExamReportReq req = new GetExamReportReq();
//            req.prtidentity = prtidentity;
            req.syNum = syNum;

            AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlSamplcheck/findBySyNum", req, new okhttpcall());
        }

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
        }

    }

    private void getdate() {

        if (TextUtils.isEmpty(write.getText().toString())) {
            Toast.makeText(ExamReportActivity.this, "请输入查询条件!", Toast.LENGTH_SHORT).show();
            return;
        }

        GetExamReportReq req = new GetExamReportReq();
        req.prtidentity = write.getText().toString();

        AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlRegister/findByPrtidentity", req, new okhttpcall());
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

            getExamReportRsp = JSON.parseObject(body, new TypeReference<BaseBeanRsp<GetExamReportRsp>>() {
            });
            mHandler.sendEmptyMessage(getExamReportRsp.verification ? GetData.MSG_SUCESS : GetData.MSG_OTHER);
        }
    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case GetData.MSG_SUCESS:

                    key[0] = getExamReportRsp.projectList.get(0).prtidentity;
                    key[1] = getExamReportRsp.projectList.get(0).itemname;
                    key[2] = getExamReportRsp.projectList.get(0).organname;
                    key[3] = getExamReportRsp.projectList.get(0).gcJgnum;
                    key[4] = getExamReportRsp.projectList.get(0).projectname;
                    key[5] = getExamReportRsp.projectList.get(0).phNum;
                    key[6] = getExamReportRsp.projectList.get(0).prNum;
                    key[7] = getExamReportRsp.projectList.get(0).prDate;
                    key[8] = getExamReportRsp.projectList.get(0).wtUnit;
                    key[9] = getExamReportRsp.projectList.get(0).noteIp;
                    key[10] = getExamReportRsp.projectList.get(0).note;
                    key[11] = getExamReportRsp.projectList.get(0).createtime;

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
                    isvisiable = syNum.length()>0?false:true;

                    break;
                case GetData.MSG_FAIL:

                    Toast.makeText(ExamReportActivity.this, "获取数据失败!", Toast.LENGTH_SHORT).show();
                    break;
                case GetData.MSG_OTHER:

                    Toast.makeText(ExamReportActivity.this, "此数据不存在!", Toast.LENGTH_SHORT).show();
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
                GetExamReportReq req = new GetExamReportReq();
                req.prtidentity = result;
                AndroidApplication.getInstance().doPostAsyncfile(GetData.morenurl + "etlRegister/findByPrtidentity", req, new okhttpcall());
            }
        }
    }


}
