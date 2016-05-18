package com.example.demox.base;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chan on 2016/5/18.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }
}
