package com.example.dragger2demo.model.interactor;

import com.example.dragger2demo.base.BaseSubscribe;
import com.example.dragger2demo.model.entiy.SingerImg;

import org.reactivestreams.Subscription;



/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   : 连接Api
 * </pre>
 */


public interface SingerImgInteractor {
    Subscription getSingerImg(String singer, BaseSubscribe<SingerImg> subscribe);
}
