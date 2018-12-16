package com.example.dragger2demo.configure;

import android.app.Application;

import com.example.dragger2demo.di.component.AppComponent;
import com.example.dragger2demo.di.component.DaggerAppComponent;
import com.example.dragger2demo.di.module.AppModule;


/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   :
 * </pre>
 */


public class App extends Application {
    private static App mContext;
    private AppComponent mAppComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mContext = this;
        getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static App getContext() {
        return mContext;
    }

}
