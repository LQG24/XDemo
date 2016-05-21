package com.example.demox.view.main;

import com.example.demox.base.ActivityScope;
import com.example.demox.base.AppComponent;
import com.example.demox.base.FragmentScoped;
import com.example.demox.view.local.LocalImageModule;
import com.example.demox.view.remote.RemoteImageModule;

import dagger.Component;

/**
 * Created by jamin on 16-5-21.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {LocalImageModule.class, RemoteImageModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
