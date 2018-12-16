package com.example.dragger2demo.di.component;

import com.example.dragger2demo.di.scope.ActivityScope;
import com.example.dragger2demo.di.module.CommonModule;
import com.example.dragger2demo.view.MainActivity;

import dagger.Component;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   :
 * </pre>
 */

@ActivityScope
@Component (modules = CommonModule.class)
public interface CommonComponent {
    void inject(MainActivity mainActivity);
}
