package com.zw.dailytask.interfaces;

import java.io.InputStream;

/**
 * Created by ZW on 2017/3/9.
 */

public interface ImageRequest {
    void onRequestImage(String result, InputStream in);
}
