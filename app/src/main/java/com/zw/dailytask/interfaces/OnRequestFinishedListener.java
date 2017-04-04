package com.zw.dailytask.interfaces;

import android.graphics.Bitmap;

import java.io.InputStream;

/**
 * Created by ZW on 2017/3/9.
 */

public interface OnRequestFinishedListener {
    void onResult(InputStream resultStream,int[]index);
}
