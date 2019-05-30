package com.example.pavithra.task1_spider;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView circle;
    float height;
    boolean[] flag = new boolean[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),getString(R.string.tap),Toast.LENGTH_LONG).show();

        for(int i =0;i<7;i++){
            flag[i] = true;
        }

        final LinearLayout layout = (LinearLayout)findViewById(R.id.layout);


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height = layout.getHeight();
                int rand = (int) (Math.random() * 6 + 1);
                getCircle(rand);
                move(rand);

            }

        });
    }

    public void setDown(){

        Animation animation = new TranslateAnimation(0,0,0,height - 120);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        circle.startAnimation(animation);
    }
    public void setUp(){
        Animation animation = new TranslateAnimation(0,0,height - 120,0);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        circle.startAnimation(animation);
    }

    public void getCircle(int rand){
        if(rand == 1){
            circle = (ImageView)findViewById(R.id.circle1);
        }
        else if(rand == 2){
            circle = (ImageView)findViewById(R.id.circle2);
        }
        else if(rand == 3){
            circle = (ImageView)findViewById(R.id.circle3);
        }
        else if(rand == 4){
            circle = (ImageView)findViewById(R.id.circle4);
        }
        else if(rand == 5){
            circle = (ImageView)findViewById(R.id.circle5);
        }
        else {
            circle = (ImageView)findViewById(R.id.circle6);
        }
    }

    public void move(int rand){
        if (flag[rand]) {
            setDown();
        }
        else {
            setUp();
        }
        flag[rand] = !flag[rand];

    }

}
