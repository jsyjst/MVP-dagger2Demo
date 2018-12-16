package com.example.dragger2demo.base;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   : 观察者
 * </pre>
 */


public abstract class BaseSubscribe<T> implements Subscriber<T> {
    private static final String TAG = "BaseSubscribe";


    @Override
    public void onSubscribe(Subscription s){
        Log.d(TAG, "onSubscribe");
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "response" + t.toString());

        onSuccess(t);
    }



    public abstract void onSuccess(T result);

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Log.i(TAG, "onError" + e.getMessage());
    }
    
    @Override
    public void onComplete(){
        Log.d(TAG, "onComplete");
    }
}
