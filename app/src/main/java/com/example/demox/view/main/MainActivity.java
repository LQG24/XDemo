package com.example.demox.view.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.example.demox.R;
import com.example.demox.base.AppComponent;
import com.example.demox.base.BaseActivity;
import com.example.demox.base.BaseApplication;
import com.example.demox.view.local.LocalImageContract;
import com.example.demox.view.local.LocalImageFragment;
import com.example.demox.view.remote.RemoteImageFragment;
import com.example.demox.view.remote.RemoteImageModule;
import com.example.demox.view.remote.RemoteImagePresenter;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab_main)
    TabLayout tabMain;

    @BindView(R.id.vp_main)
    ViewPager vpMain;

    @BindString(R.string.remote_image)
    String mRemoteImageStr;

    @BindString(R.string.local_image)
    String mLocalImageStr;

    @Inject
    RemoteImagePresenter remoteImagePresenter;

    RemoteImageFragment remoteImageFragment;
    LocalImageFragment localImageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? remoteImageFragment : localImageFragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? mRemoteImageStr : mLocalImageStr;
            }
        });

        tabMain.setupWithViewPager(vpMain);
    }

    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
        remoteImageFragment = RemoteImageFragment.newInstance();
        localImageFragment = LocalImageFragment.newInstance();
        //注入
        DaggerMainComponent.builder()
                .appComponent(BaseApplication.get(this).getAppComponent())
                .remoteImageModule(new RemoteImageModule(this, remoteImageFragment))
                .build()
                .inject(this);
    }
}
