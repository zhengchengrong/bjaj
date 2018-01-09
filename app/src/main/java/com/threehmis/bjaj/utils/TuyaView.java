package com.threehmis.bjaj.utils;
/**
 * url www.johdan.com
 *
 * @author johdan
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TuyaView extends View {

    private Bitmap inputbitmap;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mPaint;// 真实的画笔
    private float mX, mY;// 临时点坐标
    private float TOUCH_TOLERANCE = 4;
    // 保存Path路径的集合,用List集合来模拟栈，用于后退步骤
    private static List<DrawPath> savePath;
    // 记录Path路径的对象
    private DrawPath dp;

    private int screenWidth, screenHeight;// 屏幕長寬

    private class DrawPath {
        public Path path;// 路径
        public Paint paint;// 画笔
    }

    private int color = Color.parseColor("#fe0000");
    private int srokeWidth = 3;


    public TuyaView(Context context) {
        super(context);
        init(context);
    }


    public TuyaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init(context);
    }

    private void init(Context context) {

        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

    }


    public void setInputbitmap(Bitmap urlbitmap) {
        this.inputbitmap = urlbitmap;

//		if (inputbitmap==null) {
//			mBitmap = Bitmap.createBitmap(screenWidth, screenHeight,
//					Bitmap.Config.ARGB_8888);
//		}else {
//			mBitmap=ImageFactory.comp(inputbitmap).copy(Bitmap.Config.ARGB_8888, true);
//		}

        //mBitmap=Bitmap.createBitmap(newbitmap.getWidth(), newbitmap.getHeight(), newbitmap.getConfig());
        //mBitmap=ImageFactory.comp(inputbitmap).copy(Bitmap.Config.ARGB_8888, true);
        mBitmap = resizeBitmap(ImageFactory.comp(inputbitmap), screenWidth, screenHeight).copy(Bitmap.Config.ARGB_8888, true); //压缩后重新设置bitmap
        // 保存一次一次绘制出来的图形
        mCanvas = new Canvas(mBitmap);

        savePath = new ArrayList<DrawPath>();

        //刷新
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    @SuppressLint("DrawAllocation")
    @Override
    public void onDraw(Canvas canvas) {

        // 将前面已经画过得显示出来
        if (inputbitmap != null)
            canvas.drawBitmap(mBitmap, 0, 0, null);

        if (mPath != null) {
            // 实时的显示
            canvas.drawPath(mPath, mPaint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (inputbitmap != null) {

                    initPaint();
                    // 每次down下去重新new一个Path
                    mPath = new Path();
                    // 每一次记录的路径对象是不一样的
                    dp = new DrawPath();
                    dp.path = mPath;
                    dp.paint = mPaint;
                    touch_start(x, y);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (inputbitmap != null) {
                    touch_move(x, y);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                if (inputbitmap != null) {
                    touch_up();
                    invalidate();
                }
                break;
        }
        return true;
    }

    private void touch_start(float x, float y) {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touch_move(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(mY - y);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            // 从x1,y1到x2,y2画一条贝塞尔曲线，更平滑(直接用mPath.lineTo也是可以的)
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }

    private void touch_up() {
        mPath.lineTo(mX, mY);
        mCanvas.drawPath(mPath, mPaint);
        // 将一条完整的路径保存下来(相当于入栈操作)
        savePath.add(dp);
        mPath = null;// 重新置空
    }

    /**
     * 撤销的核心思想就是将画布清空， 将保存下来的Path路径最后一个移除掉， 重新将路径画在画布上面。
     */
    public void undo() {

        //mBitmap= resizeBitmap(ImageFactory.comp(inputbitmap),screenWidth,screenHeight);
        //mCanvas.setBitmap(mBitmap);// 重新设置画布，相当于清空画布
        // 清空画布，但是如果图片有背景的话，则使用上面的重新初始化的方法，用该方法会将背景清空掉…
        if (savePath != null && savePath.size() > 0) {

            mBitmap = resizeBitmap(ImageFactory.comp(inputbitmap), screenWidth, screenHeight).copy(Bitmap.Config.ARGB_8888, true);
            mCanvas.setBitmap(mBitmap);// 重新设置画布，相当于清空画布
            // 移除最后一个path,相当于出栈操作
            savePath.remove(savePath.size() - 1);

            Iterator<DrawPath> iter = savePath.iterator();
            while (iter.hasNext()) {
                DrawPath drawPath = iter.next();
                mCanvas.drawPath(drawPath.path, drawPath.paint);
            }

            invalidate();// 刷新
        }

    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    private void initPaint() {
        //初始画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);// 设置外边缘
        mPaint.setStrokeCap(Paint.Cap.ROUND);// 形状
        mPaint.setStrokeWidth(srokeWidth);// 画笔宽度
        mPaint.setColor(color);

    }

    private Bitmap resizeBitmap(Bitmap bitmap, int w, int h) {
        //设置bitmap在cavans上全屏
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int newWidth = w;
            int newHeight = h;
            float scaleWight = ((float) newWidth) / width;
            float scaleHeight = ((float) newHeight) / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWight, scaleHeight);
            Bitmap res = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            return res;

        } else {
            return null;
        }
    }


    private void clear() {
        //清除Canvas所有的
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mCanvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

        invalidate();
    }

}
