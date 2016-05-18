package com.example.demox.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chan on 2016/5/18.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpActivityComponent();
    }

    //加载activity需要的依赖模块
    protected abstract void setUpActivityComponent();
}
