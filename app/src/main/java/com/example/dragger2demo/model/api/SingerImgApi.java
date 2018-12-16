package com.example.dragger2demo.model.api;

import com.example.dragger2demo.model.entiy.SingerImg;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   : 天气接口Api
 * </pre>
 */


public interface SingerImgApi {
    @POST("web?csrf_token=&type=100")
    @FormUrlEncoded
    Observable<SingerImg> getSingerImg(@Field("s")String singer);
}
