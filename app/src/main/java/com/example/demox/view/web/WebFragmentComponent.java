package com.example.demox.view.web;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chan on 2016/5/18.
 */

@Singleton
@Component(modules = WebFragmentModel.class)
public interface WebFragmentComponent {
    void inject(WebFragment fragment);
}
