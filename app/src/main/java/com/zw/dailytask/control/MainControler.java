package com.zw.dailytask.control;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zw.dailytask.MainActivity;
import com.zw.dailytask.http.Http;
import com.zw.dailytask.interfaces.ImageRequest;

import java.io.InputStream;

/**
 * Created by ZW on 2017/3/9.
 */

public class MainControler {
    private ImageView mImage_1;
    private Button mButton_1;
    private MainActivity mMainActivity;

    public MainControler(MainActivity mainActivity, ImageView view,Button button){
        this.mMainActivity = mainActivity;
        this.mImage_1 =  view;
        this.mButton_1 = button;
        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        setImage();
                    }
                }).run();
            }
        });
    }



    private void setImage(){
        final Http http = new Http();
        new Thread(new Runnable() {
            @Override
            public void run() {
                http.getResponseObject(new ImageRequest() {
                    @Override
                    public void onRequestImage(String result, InputStream in) {

                    }
                });
            }
        }).run();

    }

}
