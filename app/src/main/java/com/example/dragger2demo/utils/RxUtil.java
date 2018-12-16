package com.example.dragger2demo.utils;

import com.example.dragger2demo.model.entiy.SingerImg;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/16
 *     desc   : 对Rxjava线程的封装
 * </pre>
 */


public class RxUtil {
    /**
     * 统一线程处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 对头像获取结果处理
     * @return
     */
    public static ObservableTransformer<SingerImg,SingerImg.ResultBean> handleSingerImgResult(){
        return new ObservableTransformer<SingerImg, SingerImg.ResultBean>() {
            @Override
            public ObservableSource<SingerImg.ResultBean> apply(Observable<SingerImg> upstream) {
                return upstream.flatMap(new Function<SingerImg, ObservableSource<SingerImg.ResultBean>>() {
                    @Override
                    public ObservableSource<SingerImg.ResultBean> apply(SingerImg singerImg) throws Exception {
                        if(singerImg.getCode() == 200){
                            return createObservable(singerImg.getResult());
                        }
                        return  null;
                    }
                });
            }
        };
    }
    /**
     * 创建成功的数据源
     */
    private static <T> Observable<T> createObservable(final T data){
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                emitter.onNext(data);
                emitter.onComplete();
            }
        });
    }
}