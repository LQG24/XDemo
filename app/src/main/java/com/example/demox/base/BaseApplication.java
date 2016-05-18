package com.example.demox.base;

import android.app.Application;

import com.grosner.dbflow.config.FlowManager;

/**
 * Created by chan on 2016/5/18.
 */
public class BaseApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)) //加载对应的依赖模块
                .build();

        FlowManager.init(this);//初始化数据库框架
    }
}
