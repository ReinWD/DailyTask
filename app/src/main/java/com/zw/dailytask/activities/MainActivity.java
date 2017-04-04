package com.zw.dailytask.activities;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.zw.dailytask.Model;
import com.zw.dailytask.R;
import com.zw.dailytask.adapter.MainAdapter;
import com.zw.dailytask.control.MainControler;
import com.zw.dailytask.interfaces.OnImageReadyListener;

public class MainActivity extends AppCompatActivity implements OnImageReadyListener {
    private static final String TAG = "MainActivity";

    RecyclerView mRecyclerViewMain;
    StaggeredGridLayoutManager manager;
    MainAdapter mAdapterMain;
    MainControler mControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mControler = new MainControler(this);
        initview();
        Log.i(TAG, "onCreate:successfully finished");

    }

    void initview() {
        //----------------------------------------------------------------------------
        //RecyclerView
        mRecyclerViewMain = (RecyclerView) findViewById(R.id.recycler_main);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerViewMain.setLayoutManager(manager);
        mAdapterMain = new MainAdapter(this);
        mRecyclerViewMain.setAdapter(mAdapterMain);
        //----------------------------------------------------------------------------
    }

    @Override
    public void onDataReady(Bitmap bitmap, @NonNull int... index) {
        mAdapterMain.setData(bitmap,index[1]);
    }

}
