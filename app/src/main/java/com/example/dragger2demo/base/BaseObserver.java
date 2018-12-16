package com.example.dragger2demo.base;

import android.util.Log;
import android.view.View;

import com.example.dragger2demo.model.http.entiy.SingerImg;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   : observe的基类
 * </pre>
 */


public abstract class BaseObserver<T> extends ResourceObserver<T> {
    private String TAG = "BaseObserver";

    private Disposable disposable;
    private BaseView mView;

    protected BaseObserver(BaseView view){
        mView = view;
    }




    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: "+e.toString());
    }



    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }
}
