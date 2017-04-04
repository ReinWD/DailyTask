package com.zw.dailytask.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.zw.dailytask.Model;
import com.zw.dailytask.Value;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ZW on 2017/3/21.
 */

public class Json {
//
//    private static final String TAG = "Json";
//
//    static int currentBlockLayer = -1, currentArrayLayer = -1;
//    static Value values=null;
//    static String key = null;
//    static String arrayKey;
//
//    public static Value analyzeData(String rawData) {
//        boolean isKey = true;
//        boolean isArray = false;
//        values = new Value(Value.TYPE_BASE);
//        StringReader reader = new StringReader(rawData);
//        ByteArrayOutputStream writer = new ByteArrayOutputStream();
//        try {
//            int in;
//            while ((in = reader.read()) != -1) {
//                switch (in) {
//                    case 10:// space
//                        break;
//                    case 32:// space
//                        break;
//                    case 123:// {
//                        currentBlockLayer++;
//                        break;
//                    case 125:// }
//                        currentBlockLayer--;
//                        break;
//                    case 34:// "
//                        boolean hasData = writer.size() != 0;
//                        if (hasData) {
//                            String data = writer.toString();
//                            if(currentBlockLayer>1){
//
//                            }
//                            put(data);
//                            writer.reset();
//                        }
//                        break;
//                    case 58:// :
//                        if (writer.size() != 0) {
//                            writer.write(in);
//                        } else isKey = false;
//                        break;
//                    case 44:// ,
//                        hasData = writer.size() != 0;
//                        String data = writer.toString();
//                        if (hasData) {
//                            put(data);
//                            writer.reset();
//                        }
//                        isKey = true;
//                        break;
//                    case 91:// [
//                        currentArrayLayer++;
//                        arrayKey = key;
//                        break;
//                    case 93:// ]
//                        currentArrayLayer--;
//                        values = null;
//                        break;
//                    default:
//                        writer.write(in);
//                }
//            }
//        } catch (IOException e) {
//
//        }
//        if (values == null) {
//            return null;
//        }
//        return values;
//    }
//
//    static void put(String data) {
//        if(currentArrayLayer!=currentBlockLayer-1){
//            values.put(data);
//        }else;
//    }

//以上是自己手动解析的类（并没做好）

    static Gson gson = new Gson();
    public static Object generateModel(String rawData,Class target) throws IOException {
        return gson.fromJson(rawData,target);
    }
}
