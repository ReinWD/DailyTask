package com.zw.dailytask.interfaces;

import android.graphics.Bitmap;

/**
 * Created by ZW on 2017/4/4.
 */

public interface OnImageReadyListener {
    public void onDataReady(Bitmap bitmap,int ... index);
}
