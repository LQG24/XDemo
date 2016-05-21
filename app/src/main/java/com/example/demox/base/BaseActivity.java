package com.example.demox.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jamin on 16-5-20.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setUpActivityComponent(BaseApplication.get(this).getAppComponent());
    }

    //加载activity的依赖注入模块
    protected abstract void setUpActivityComponent(AppComponent appComponent);

}
