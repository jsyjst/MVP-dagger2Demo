package com.example.dragger2demo.model;

import com.example.dragger2demo.model.http.HttpHelper;
import com.example.dragger2demo.model.http.RetrofitHelper;
import com.example.dragger2demo.model.http.entiy.SingerImg;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   :
 * </pre>
 */


public class DataModel implements HttpHelper {
    private HttpHelper mRetrofitHelp;

    @Inject
    public DataModel(RetrofitHelper httpHelper){
        mRetrofitHelp = httpHelper;
    }

    @Override
    public Observable<SingerImg> getSingerImg(String singer) {
        return mRetrofitHelp.getSingerImg(singer);
    }
}
