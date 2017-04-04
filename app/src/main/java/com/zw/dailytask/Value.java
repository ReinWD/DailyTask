package com.zw.dailytask;

import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Value<T extends Object> {
    private static final String TAG = "Value";

    public static final int TYPE_STRING = 1;
    public static final int TYPE_BOOLEAN = 2;
    public static final int TYPE_ARRAY = 3;
    public static final int TYPE_BASE = 4;
    ArrayList<HashMap<String, Value>> dataArray;
    HashMap<String,Value> item;
    private int type;
    private String value;
    private boolean bool;


    public Value(int type) {
        this.type = type;
        switch (type){
            case TYPE_STRING:
                value = null;
                break;
            case TYPE_BOOLEAN:
                break;
            case TYPE_ARRAY:
                dataArray = new ArrayList<>();
                break;
            case TYPE_BASE:
                item = new HashMap<>();
                break;
        }
    }

    public Value put(String value) {
        switch (this.getType()) {
            case TYPE_STRING:
                this.value = value;
                break;
            case TYPE_BOOLEAN:
                this.bool = value.equals("true");
                break;
        }
        return this;
    }

    public Value put(String key,String value){
        this.item.put(key,new Value(TYPE_STRING).put(value));
        return this;
    }

    public Value put(HashMap<String, Value> value) {
        this.dataArray.add(value);
        return this;
    }

    public Object getData() {
        switch (type) {
            case TYPE_ARRAY:
                return dataArray;
            case TYPE_BOOLEAN:
                return bool;
            case TYPE_STRING:
                return value;
            case TYPE_BASE:
                return item;
            default:
                return null;
        }
    }

    public int getType() {
        return type;
    }

    public T generateObject(Class<T> target) throws IllegalAccessException, InstantiationException {
        Class targetClass = target;
        T result = target.newInstance();
        return null;
    }

}