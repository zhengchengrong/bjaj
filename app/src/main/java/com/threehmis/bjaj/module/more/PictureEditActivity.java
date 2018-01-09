package com.threehmis.bjaj.module.more;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.threehmis.bjaj.AndroidApplication;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.api.GetData;
import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.respon.StateSuccessRsp;
import com.threehmis.bjaj.utils.TuyaView;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PictureEditActivity extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    private TuyaView tuyav;
    private String checkId;
    private String photoId;
    BaseBeanRsp<StateSuccessRsp> stateSuccessRsp;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_edit);

        String intupUrl = getIntent().getStringExtra("intupUrl");
        checkId = getIntent().getStringExtra("checkId");
        photoId = getIntent().getStringExtra("photoId");

        TextView reset = (TextView) findViewById(R.id.reset);
        TextView save = (TextView) findViewById(R.id.save);
        TextView exit = (TextView) findViewById(R.id.exit);
        tuyav = (TuyaView) findViewById(R.id.tuyav);
        reset.setOnClickListener(this);
        save.setOnClickListener(this);
        exit.setOnClickListener(this);


        getHttpBitmap(intupUrl);
    }


    /**
     * 获取网落图片资源
     *
     * @param url
     * @return
     */
    public void getHttpBitmap(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL myFileURL;
                Bitmap bitmap = null;
                try {
                    myFileURL = new URL(url);
                    // 获得连接
                    HttpURLConnection conn = (HttpURLConnection) myFileURL
                            .openConnection();
                    // 设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
                    conn.setConnectTimeout(6000);
                    // 连接设置获得数据流
                    conn.setDoInput(true);
                    // 不使用缓存
                    conn.setUseCaches(false);
                    // 这句可有可无，没有影响
                    // conn.connect();
                    // 得到数据流
                    InputStream is = conn.getInputStream();
                    // 解析得到图片
                    bitmap = BitmapFactory.decodeStream(is);
                    handler.sendMessage(handler.obtainMessage(100, bitmap));
                    // 关闭数据流
                    is.close();
                } catch (Exception e) {
                    handler.sendMessage(handler.obtainMessage(500,
                            "获取网络图片失败...."));
                    e.printStackTrace();
                }
            }
        }).start();
    }

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case 100:
                    bitmap = (Bitmap) msg.obj;
                    System.out.println("xxxxxbitmap==" + bitmap);
                    tuyav.setInputbitmap(bitmap);
                    break;
                case 500:
                    Toast.makeText(getApplicationContext(), msg.obj.toString(), Toast.LENGTH_LONG)
                            .show();
                    break;

                default:
                    break;
            }
        }

        ;
    };


    /**
     * 保存到本地方法
     */
    public File saveBitmap(Bitmap bm) {


        File f = new File("mnt/sdcard/DCIM/Camera/editpic.jpg");

        if (f.exists())
            f.delete();

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
            bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            System.out.println("保存到本地。。。。。。。。。。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.reset:
                //撤消
                tuyav.undo();
                break;
            case R.id.save:
                //保存
//                new Thread() {
//                    @Override
//                    public void run() {
//                        saveBitmap(tuyav.getBitmap());
//                    }
//                }.start();
                saveEditphoto();


                break;
            case R.id.exit:
                //退出
                finish();
                break;
        }
    }


    void saveEditphoto() {

        File editimageFile = saveBitmap(tuyav.getBitmap());

        if (editimageFile != null) {
            dialog = new ProgressDialog(this);

            dialog.setCanceledOnTouchOutside(true);

            dialog.setTitle("正在上传...");

            dialog.show();

            AndroidApplication.getInstance().doPostAsyncEditimage(GetData.baseurl + "supervise/saveEditPhoto", editimageFile, checkId, photoId, "photo", new okhttpcall());
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

            stateSuccessRsp = JSON.parseObject(body, new TypeReference<BaseBeanRsp<StateSuccessRsp>>() {
            });
            mHandler.sendEmptyMessage(stateSuccessRsp.verification ? GetData.MSG_SUCESS : GetData.MSG_FAIL);

        }
    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case GetData.MSG_SUCESS:

                    Toast.makeText(AndroidApplication.getInstance(), "上传照片成功!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setAction(ActionHistoryFragment.DATAREFRESH);
                    sendBroadcast(intent);

                    if (dialog!=null)
                    dialog.dismiss();
                    finish();
                    break;
                case GetData.MSG_FAIL:

                    Toast.makeText(App.getInstance(), "上传照片失败!", Toast.LENGTH_SHORT).show();
                    if (dialog!=null)
                        dialog.dismiss();

                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        handler.removeCallbacksAndMessages(null);
        if (dialog!=null)
            dialog.dismiss();
        if (bitmap != null && !bitmap.isRecycled())
            bitmap.recycle();
    }
}
