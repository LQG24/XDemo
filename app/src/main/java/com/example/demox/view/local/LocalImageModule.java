package com.example.demox.view.local;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chan on 2016/5/18.
 */

@Module
public class LocalImageModule {

    @Provides
    LocalImageContract.Model provideModel() {
        return new LocalImageModel();
    }
}
