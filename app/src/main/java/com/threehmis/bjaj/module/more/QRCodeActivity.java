package com.threehmis.bjaj.module.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.threehmis.bjaj.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

import static android.content.ContentValues.TAG;

public class QRCodeActivity extends Activity implements QRCodeView.Delegate, View.OnClickListener {

    private ZXingView zxing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        TextView back = (TextView) findViewById(R.id.back);
        back.setOnClickListener(this);
        zxing = (ZXingView) findViewById(R.id.zxing);
        zxing.setDelegate(this);
//        zxing.startSpot();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {


        //得到结果做解密处理
//            String draw = URLDecoder.decode(Algorithm.DesDecrypt(result, GetData.KeyStr), "UTF-8");
//            // {"DrawId":"19"}
//            JSONObject object = new JSONObject(draw);
//            int drawid = object.getInt("DrawId");

        //Toast.makeText(QRCodeActivity.this, "得到结果数据==>" + result, Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.putExtra("result", result);
        setResult(Activity.RESULT_OK, intent);

        this.finish();

    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        zxing.startCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zxing.startSpotAndShowRect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        zxing.stopSpotAndHiddenRect();
    }

    @Override
    protected void onDestroy() {
        zxing.stopCamera();
        zxing.onDestroy();
        super.onDestroy();
    }

    //震动器
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }


}
