package com.example.dragger2demo.di.component;

import com.example.dragger2demo.configure.App;
import com.example.dragger2demo.di.module.AppModule;
import com.example.dragger2demo.model.DataModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import retrofit2.Retrofit;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   :
 * </pre>
 */

@Singleton
@Component (modules = AppModule.class)
public interface AppComponent {
    void inject(App app);

    App getApp();
    Retrofit getRetrofit();
    DataModel getDataModel();
}
