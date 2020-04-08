package com.example.myjnibitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.io.ByteArrayOutputStream;

public class BlurBitmap {

    static {
        System.loadLibrary("native-lib");

    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */


    public Bitmap blur(Bitmap srcBitmap){
        blurBitmap(srcBitmap,20);
        return srcBitmap;
    }
    public native void blurBitmap(Bitmap bmp,int num);

    public static Bitmap compressScale(Bitmap bmp) {
        // 尺寸压缩倍数,值越大，图片尺寸越小
        int ratio = 5;
        // 压缩Bitmap到对应尺寸
        Bitmap result = Bitmap.createBitmap(bmp.getWidth() / ratio, bmp.getHeight() / ratio, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Rect rect = new Rect(0, 0, bmp.getWidth() / ratio, bmp.getHeight() / ratio);
        canvas.drawBitmap(bmp, null, rect, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        result.compress(Bitmap.CompressFormat.JPEG, 60 ,baos);
        return result;
    }
}
