package com.example.dragger2demo.base;

import android.provider.ContactsContract;

import com.example.dragger2demo.model.DataModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   :
 * </pre>
 */


public class BasePresenter<V extends BaseView> {
    protected V mView;
    protected DataModel mDataModel;
    private CompositeDisposable mCompositeDisposable;

    @Inject
    public BasePresenter(DataModel model){
        mDataModel = model;
    }

    public void attachView(V view){
        mView = view;
    }
    public boolean isAttachView(){
        return mView != null;
    }

    public void detachView(){
        mView = null;
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    public void addSubcriber(Disposable disposable){
        if(mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}
