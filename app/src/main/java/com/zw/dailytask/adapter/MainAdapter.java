package com.zw.dailytask.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zw.dailytask.Model;
import com.zw.dailytask.R;
import com.zw.dailytask.activities.MainActivity;

import java.util.ArrayList;

/**
 * Created by ZW on 2017/3/21.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private static final String TAG = "MainAdapter";
    private MainActivity mContext;
    private Model mModel;
    private Bitmap[] mBitmaps;

    public MainAdapter(MainActivity context) {
        this.mContext = context;
        init();
    }

    void init() {
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View imageView = LayoutInflater.from(mContext).inflate(R.layout.recycler_main, parent, false);
        return new ViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        try {
            Bitmap bitmap = mBitmaps[position];
            if (bitmap != null) {
                holder.mImageView.setAdjustViewBounds(true);
                holder.mImageView.setImageBitmap(bitmap);
                Log.d(TAG, "onBindViewHolder: bitmap added at position:" + position);
            } else {
                Log.d(TAG, "onBindViewHolder: bitmap null at position:" + position);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public int getItemCount() {
        if (mBitmaps == null) return 0;
        else return mBitmaps.length;

    }

    public void setData(Bitmap bitmap, final int index) {
        if (mBitmaps == null) {
            mBitmaps = new Bitmap[10];
        }
        mBitmaps[index] = bitmap;
        mContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                notifyItemChanged(index);
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.image_recycler_main);
        }
    }


}
