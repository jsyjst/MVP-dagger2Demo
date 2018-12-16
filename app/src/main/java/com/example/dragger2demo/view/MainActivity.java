package com.example.dragger2demo.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.dragger2demo.R;
import com.example.dragger2demo.contract.ILoginContract;

import com.example.dragger2demo.model.entiy.User;

import com.example.dragger2demo.presenter.LoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ILoginContract.IView {

    @BindView(R.id.loginBtn)
    Button loginBtn;
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        DaggerCommonComponent.
//                builder().
//                commonModule(new CommonModule(this))
//                .build().inject(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.loginBtn)
    public void onClick() {
        presenter.login(new User());
    }
}
