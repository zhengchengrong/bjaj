package com.threehmis.bjaj.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.threehmis.bjaj.R;
import com.threehmis.bjaj.module.more.EtlSamplcheckActivity;
import com.threehmis.bjaj.module.more.ExamReportActivity;
import com.threehmis.bjaj.module.more.IcScanActivity;
import com.threehmis.bjaj.utils.ScreenUtil;


/**
 * @author CD
 *         拍照录音录像dialog
 *         回调在ActionCheckActivity
 */
public class MainMoreDialog extends Dialog implements
        View.OnClickListener {

    Activity context;


    public MainMoreDialog(Activity context) {
        this(context, R.style.enterDialog);
        this.context = context;
    }

    public MainMoreDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_more_dialog);
        Window window = getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.alpha = 1.0f;
        wl.gravity = Gravity.BOTTOM;
        wl.width = ScreenUtil.getScreenWidth(context);
        window.setAttributes(wl);
        setCancelable(true);
        setCanceledOnTouchOutside(true);

        findViewById(R.id.test_check).setOnClickListener(this);
        findViewById(R.id.scene_check).setOnClickListener(this);
        findViewById(R.id.chip_check).setOnClickListener(this);
        findViewById(R.id.cancer).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cancel();
        switch (v.getId()) {
            case R.id.test_check:
                Intent intent = new Intent(context, ExamReportActivity.class);
                context.startActivity(intent);
                break;
            case R.id.scene_check:
                Intent intent1 = new Intent(context, EtlSamplcheckActivity.class);
                context.startActivity(intent1);
                break;
            case R.id.chip_check:
                Intent intent2 = new Intent(context, IcScanActivity.class);
                context.startActivity(intent2);

                break;
        }
    }


}
