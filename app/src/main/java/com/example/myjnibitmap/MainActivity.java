package com.example.myjnibitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv_Bitmap =findViewById(R.id.iv_Bitmap);
        BlurBitmap blurBitmap = new BlurBitmap();
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.timg);
        bmp= blurBitmap.blur(bmp);
        iv_Bitmap.setImageBitmap(bmp);
    }


}
