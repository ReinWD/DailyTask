package com.zw.dailytask.http;


import android.os.Handler;

import com.zw.dailytask.interfaces.ImageRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by ZW on 2017/3/9.
 */

public class Http {
    private HttpsURLConnection mConnection;
    private URL mTarget_1;
    private InputStream mInputStream_1;

    public Http() {
    }

    public Object getResponseObject(ImageRequest imageRequest){
        return request(imageRequest);
    }

    private Object request(final ImageRequest imageRequest) {
        final Object[] ob = new Object[1];
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mTarget_1 = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999" +
                            "_10000&sec=1489666226&di=bbc037d4ac9f803960867bcb1cd22b87&imgtype=jpg&er" +
                            "=1&src=http%3A%2F%2Fimg007.hc360.cn%2Fhb%2FwXaf128f55d36000Bd2d375aB623079f3B.jpg\n");
                    mConnection = (HttpsURLConnection) mTarget_1.openConnection();
                    mConnection.setConnectTimeout(5000);
                    mConnection.setReadTimeout(5000);
                    mConnection.setUseCaches(false);
                    mConnection.setRequestMethod("POST");
                    mInputStream_1 = mConnection.getInputStream();
                    //
                    BufferedReader bufferedReader = new BufferedReader
                            (new InputStreamReader(mInputStream_1));
                    String cache;
                    StringBuilder builder = new StringBuilder();
                    while (!((cache = bufferedReader.readLine())==null)){
                        builder.append(cache);
                    }
                    imageRequest.onRequestImage(builder.toString(),mInputStream_1);
                    mInputStream_1.close();} catch (IOException e) {
                    e.printStackTrace();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ob[0] =  mConnection.getContent();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                }
            }
        }).run();

            return ob[0];


    }
}
