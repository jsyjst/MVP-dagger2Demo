package com.example.dragger2demo.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.dragger2demo.R;
import com.example.dragger2demo.configure.App;
import com.example.dragger2demo.contract.ILoginContract;


import com.example.dragger2demo.di.component.activity.DaggerMainComponent;
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
        DaggerMainComponent.builder().appComponent(App.getContext().getAppComponent()).build()
                .inject(this);
        presenter.attachView(this);

    }
    @OnClick(R.id.loginBtn)
    public void onClick() {
        presenter.getSingerImg("周杰伦");
    }

    @Override
    public void showNormalView() {

    }

    @Override
    public void showImgPic(String pic) {
        Toast.makeText(MainActivity.this,pic,Toast.LENGTH_SHORT).show();
    }
}
