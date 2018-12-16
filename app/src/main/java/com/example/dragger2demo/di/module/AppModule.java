package com.example.dragger2demo.di.module;

import com.example.dragger2demo.ConstantApi;
import com.example.dragger2demo.configure.App;
import com.example.dragger2demo.model.http.api.SingerImgApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   : 提供对应api的Retrofit实例
 * </pre>
 */

@Module
public class AppModule {
    private final App mApp;

    public AppModule(App app){
        mApp =app;
    }
    @Provides
    @Singleton
    App providesApp(){
        return mApp;
    }

    @Provides
    @Singleton
    OkHttpClient.Builder providesOkHttpClientBuilder(){
        return new OkHttpClient.Builder();
    }
    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(OkHttpClient.Builder builder){
        builder.connectTimeout(20, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder().baseUrl(ConstantApi.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Provides
    @Singleton
    SingerImgApi providesSingerImgApi(Retrofit retrofit){
        return retrofit.create(SingerImgApi.class);
    }

}
