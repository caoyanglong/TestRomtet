package com.yyhd.proto;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.bitmap);
    }

    public void test1(View view){
        Observable.just("one", "two", "three", "four", "five")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("<maintacitivity>",s);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        createObserver().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        Log.e("<mainactivity>","onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("<mainactivity>",s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e("<mainactivity>","onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("<mainactivity>","onComplete");
                    }
                });
    }

    public void test2(View view){
        //在2.0后命名规则有了改变

        //Action1--------Consumer一个参数的

        //Action2--------BiConsumer两个参数的
        //而Function的也一样
//        Observable.just("http://img2.imgtn.bdimg.com/it/u=4225722360,1367332860&fm=27&gp=0.jpg").map(new Function<String, Bitmap>() {
//            @Override
//            public Bitmap apply(String s) throws Exception {
//                return BitmapFactory.decodeStream(new URL(s).openConnection().getInputStream());
//            }
//        }).subscribeOn(Schedulers.io())//指定 subscribe() 事件发送发生在 IO 线程
//                .observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调处理发生在主线程
//                //这里的Action一个参数的改为COnsumer
//                .subscribe(new Consumer<Bitmap>() {
//                    @Override
//                    public void accept(Bitmap bitmap) throws Exception {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });


        Observable.just("test1").map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s+"map1";
            }
        })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s+"map2";
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s+"map3";
                    }
                })
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final String s) throws Exception {
                        return new Observable<String>() {
                            @Override
                            protected void subscribeActual(Observer<? super String> observer) {
                                observer.onNext(s+"hello");
                            }
                        };
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable disposable) {
//                        Log.e("<mainactivity>","onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.e("<mainactivity>","onNext----"+s);
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        Log.e("<mainactivity>","onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e("<mainactivity>","onComplete");
//                    }
//                });
    }



    private Observable<String> createObserver(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                SystemClock.sleep(3000);
                observableEmitter.onNext("hello_observerble");
                observableEmitter.onComplete();
            }
        });
    }
}
