package com.example.dragger2demo.contract;

import android.content.Context;

import com.example.dragger2demo.base.BaseView;
import com.example.dragger2demo.model.http.entiy.User;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/14
 *     desc   :
 * </pre>
 */


public interface ILoginContract {
    interface IView extends BaseView{
        void showImgPic(String pic);
    }
    interface IPresenter{
        void getSingerImg(String singer);
    }
}
