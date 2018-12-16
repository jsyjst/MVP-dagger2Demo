package com.example.dragger2demo.model;

import com.example.dragger2demo.ConstantApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   : Retrofit的实体类
 * </pre>
 */


public class RetrofitHelper {
    private static Retrofit retrofit = null;

    public static Retrofit getInstance(){
        if(retrofit == null){
            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
            OkHttpClient okHttpClient = new OkHttpClient();
            OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.retryOnConnectionFailure(true);
            retrofit = new Retrofit.Builder().client(okHttpClient)
                    .baseUrl(ConstantApi.BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
