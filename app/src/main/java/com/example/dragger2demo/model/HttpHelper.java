package com.example.dragger2demo.model;

import com.example.dragger2demo.model.entiy.SingerImg;

import io.reactivex.Observable;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   : 网络操作接口
 * </pre>
 */


public interface HttpHelper {
    //得到头像地址
    Observable<SingerImg> getSingerImg(String singer);
}
