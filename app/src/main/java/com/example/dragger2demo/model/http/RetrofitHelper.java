package com.example.dragger2demo.model.http;

import com.example.dragger2demo.model.http.api.SingerImgApi;
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


public class RetrofitHelper implements HttpHelper {

    private SingerImgApi mSingerImgApi;

    @Inject
    public RetrofitHelper(SingerImgApi singerImgApi){
        mSingerImgApi = singerImgApi;

    }
    @Override
    public Observable<SingerImg> getSingerImg(String singer) {
        return mSingerImgApi.getSingerImg(singer);
    }
}
