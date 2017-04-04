package com.zw.dailytask.utils;


import android.support.annotation.Nullable;
import android.util.Log;

import com.zw.dailytask.interfaces.OnRequestFinishedListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ZW on 2017/3/9.
 */

public class Http {
    private final String TAG = "Http";
    private OnRequestFinishedListener mListener;
    private int [] index;
//    private HttpURLConnection mConnection;
//    private URL mTarget_1;
//    private InputStream mInputStream_1;
//
//    public Http(){}
//
//    public void request(final String url, final OnRequestFinishedListener listener, final int index){
//        final String[] result = new String[1];
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    mTarget_1 = new URL(url);
//                    mConnection = (HttpURLConnection) mTarget_1.openConnection();
//                    mConnection.setConnectTimeout(5000);
//                    mConnection.setReadTimeout(5000);
//                    mConnection.setUseCaches(false);
//                    mConnection.setRequestMethod("GET");
//                    mConnection.connect();
//                    mInputStream_1 = mConnection.getInputStream();
//                    listener.onRequestFinished(mInputStream_1,index);
//                    mInputStream_1.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();}

    public Http(OnRequestFinishedListener listener,int ... index ){
        this.mListener = listener;
    this.index = index;}

    OkHttpClient httpClient;

    public void requestData(String url){
        if (httpClient == null){
            buildClint();
        }
        Request request = new Request.Builder()
                .get()
                .url(url).build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "on requestData():",e );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mListener.onResult(response.body().byteStream(),index);
            }
        });
    }

    private void buildClint(){
        httpClient =new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
    }

    public static String readData(InputStream in){
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String cache;
        StringBuilder builder= new StringBuilder();
        try {
            while ((cache =reader.readLine())!=null) {
                builder.append(cache);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = builder.toString();
        return result;
    }
}
