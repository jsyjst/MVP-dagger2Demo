package com.example.dragger2demo.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.dragger2demo.contract.ILoginContract;
import com.example.dragger2demo.model.entiy.User;

import javax.inject.Inject;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   :
 * </pre>
 */


public class LoginPresenter implements ILoginContract.IPresenter {
    private ILoginContract.IView iView;

    @Inject
    public  LoginPresenter(ILoginContract.IView view){
        iView = view;
    }
    @Override
    public void login(User user) {
        Context context = iView.getContext();
        Toast.makeText(context,"login...",Toast.LENGTH_SHORT).show();
    }
}
