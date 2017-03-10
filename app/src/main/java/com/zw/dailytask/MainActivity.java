package com.zw.dailytask;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.zw.dailytask.control.MainControler;

public class MainActivity extends AppCompatActivity {

    ImageView mImage_1;
    Button mButton_1;
    MainControler mMainControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage_1 = (ImageView) findViewById(R.id.image_main_1);
        mButton_1 = (Button) findViewById(R.id.button_main_1);
        mMainControler = new MainControler(this,mImage_1,mButton_1);
    }
}
