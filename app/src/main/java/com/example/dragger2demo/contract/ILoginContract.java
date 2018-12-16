package com.example.dragger2demo.contract;

import android.content.Context;

import com.example.dragger2demo.model.entiy.User;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   :
 * </pre>
 */


public interface ILoginContract {
    interface IView{
        Context getContext();
    }
    interface IPresenter{
        void login(User user);
    }
}
