package com.example.dragger2demo.di.module;

import com.example.dragger2demo.contract.ILoginContract;
import com.example.dragger2demo.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   :
 * </pre>
 */

@Module
public class CommonModule {
    private ILoginContract.IView iView;

    public CommonModule(ILoginContract.IView view){
        iView = view;
    }
    @Provides
    @ActivityScope
    public ILoginContract.IView provideILoginView(){
        return this.iView;
    }
}
