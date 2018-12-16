package com.example.dragger2demo.di.component.activity;

import com.example.dragger2demo.di.component.AppComponent;


import com.example.dragger2demo.di.module.activity.MainActivityModule;
import com.example.dragger2demo.di.scope.ActivityScope;
import com.example.dragger2demo.view.MainActivity;

import dagger.Component;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   :
 * </pre>
 */

@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
