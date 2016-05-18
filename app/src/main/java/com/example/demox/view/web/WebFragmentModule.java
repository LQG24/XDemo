package com.example.demox.view.web;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.demox.data.api.PretendBApi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chan on 2016/5/18.
 */
@Module
public class WebFragmentModule {
    private static final String PROPERTIES_FILE_NAME = "url.properties";
    private static final String WEB_URL = "web_url";
    Context mContext;
    WebFragmentContract.View mView;
    WebFragmentContract.Model mModel;
    WebFragmentContract.Presenter mPresenter;

    public WebFragmentModule(Context context, WebFragmentContract.View view) {
        this.mContext = context;
        this.mView = view;
    }

    @Provides
    public PretendBApi providePretendApi() {
        Properties properties = new Properties();
        try {
            properties.load(mContext.getAssets().open(PROPERTIES_FILE_NAME));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String url = properties.getProperty(WEB_URL);
        return new Retrofit.Builder().
                baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PretendBApi.class);
    }

    @Provides
    public WebFragmentContract.View provideView() {
        return mView;
    }



}
