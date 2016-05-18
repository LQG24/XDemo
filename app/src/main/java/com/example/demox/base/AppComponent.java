package com.example.demox.base;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chan on 2016/5/18.
 */
@Singleton
@Component(modules =  AppModule.class)
public interface AppComponent {
   Application getApplication();
}
