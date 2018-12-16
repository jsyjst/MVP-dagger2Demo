package com.example.dragger2demo.presenter;



import android.util.Log;

import com.example.dragger2demo.base.BaseObserver;
import com.example.dragger2demo.base.BasePresenter;
import com.example.dragger2demo.contract.ILoginContract;
import com.example.dragger2demo.model.DataModel;
import com.example.dragger2demo.model.http.entiy.SingerImg;

import com.example.dragger2demo.utils.RxUtil;

import javax.inject.Inject;



/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   :
 * </pre>
 */


public class LoginPresenter extends BasePresenter<ILoginContract.IView>implements ILoginContract.IPresenter {
    private String TAG = "LoginPresenter";
    private DataModel mModel;

    @Inject
    public LoginPresenter(DataModel model){
        super(model);
        mModel = model;
    }

    @Override
    public void getSingerImg(final String singer) {
        addSubcriber(
                mModel.getSingerImg(singer)
                .compose(RxUtil.<SingerImg>rxSchedulerHelper())
                .compose(RxUtil.handleSingerImgResult())
                .subscribeWith(new BaseObserver<SingerImg.ResultBean>(mView){

                    @Override
                    public void onNext(SingerImg.ResultBean resultBean) {
                        Log.d(TAG, "OnNext: "+resultBean.getArtists().get(0).getPicUrl());
                        mView.showImgPic(resultBean.getArtists().get(0).getPicUrl());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }

                })
        );
    }
}
