package com.zw.dailytask.control;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.zw.dailytask.Model;
import com.zw.dailytask.interfaces.OnImageReadyListener;
import com.zw.dailytask.interfaces.OnRequestFinishedListener;
import com.zw.dailytask.utils.Http;
import com.zw.dailytask.utils.Json;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ZW on 2017/3/9.
 */

public class MainControler implements OnRequestFinishedListener {
    private static final String TAG = "MainControler";
    private static final int TYPE_JSON = 1;
    private static final int TYPE_IMAGE = 2;
    private static final int TYPE_STRING = 3;

    String api;
    String[] urls;
    ArrayList<Bitmap> bitmapArrayList = new ArrayList<>();
    Model mModel;
    OnImageReadyListener imageReadyListener;

    public MainControler(OnImageReadyListener listener) {
        this.imageReadyListener = listener;
            initData();
        requestData();
    }

    @Override
    public void onResult(InputStream result, int[] index) {
        switch (index[0]){
            case TYPE_IMAGE:
                imageReadyListener.onDataReady(BitmapFactory.decodeStream(result),index);
                Log.i(TAG, "onResult: image "+index[1]+" has successfully loaded.");
                break;
            case TYPE_JSON:
                try {
                    mModel = (Model) Json.generateModel(Http.readData(result),Model.class);
                    Log.i(TAG, "onResult: successfully received Data");
                    ArrayList<Model.Results> urlList = mModel.getResults();
                    for (int i = 0; i < urlList.size(); i++) {
                        Http http = new Http(this,TYPE_IMAGE,i);
                        http.requestData(urlList.get(i).getUrl());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "onResult: ",e );
                }
                break;
            case TYPE_STRING:
                break;
            default:
                break;
        }
    }

    public void requestData(){
        Http httpClient = new Http(this,TYPE_JSON,0);
        httpClient.requestData(api);
    }

    private void initData() {
        api = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    }

//
//    @Override
//    public void onRequestFinished(InputStream result, int index) {
//        urls = mModel.getData(readData(result));
//        for (int i = 0; i < urls.length; i++) {
//            bitmapArrayList.add(null);
//        }
//        mModel.notifyDataSetReady(urls.length, bitmapArrayList);
//        BitMapLoader bitMapLoader = new BitMapLoader();
//        for (int i = 0; i < urls.length; i++) {
//            new Http().request(urls[i], bitMapLoader,i);
//        }
//    }
//
//    @Nullable
//    public String[] getData(String rawData) {
//        Value data = Json.generateModel(rawData);
//        if (!isError()) {
//            Json.Value result = data.get("result");
//            ArrayList<HashMap<String, Json.Value>> itemList =
//                    (ArrayList<HashMap<String, Json.Value>>) result.getData();
//            String[] string = new String[itemList.size()];
//            for (int i = 0; i < itemList.size(); i++) {
//                string[i] = (String) itemList.get(i).get("URL").getData();
//            }
//            return string;
//        } else return null;
//    }
//
//
//
//    class BitMapLoader implements OnRequestFinishedListener {
//        @Override
//        public void onRequestFinished(InputStream result, int index) {
//            Bitmap bitmap = BitmapFactory.decodeStream(result);
//            if(bitmap!=null) Log.d(TAG, "onRequestFinished: bitmap "+index+"set");
//            else Log.d(TAG, "onRequestFinished: bitmap "+index+"is null");
//            bitmapArrayList.set(index, bitmap);
//            mModel.notifyDataSetReady(index, bitmapArrayList);
//        }
//    }
}
