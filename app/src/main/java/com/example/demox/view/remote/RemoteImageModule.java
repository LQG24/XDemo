package com.example.demox.view.remote;

import android.content.Context;

import com.example.demox.data.api.PretendBApi;
import com.example.demox.view.adapter.PretendBAdapter;

import java.io.IOException;
import java.util.Properties;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chan on 2016/5/18.
 */
@Module
public class RemoteImageModule {
    private static final String PROPERTIES_FILE_NAME = "url.properties";
    private static final String WEB_URL = "web_url";
    Context mContext;
    RemoteImageContract.View mView;

    public RemoteImageModule(Context context, RemoteImageContract.View view) {
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

    /**
     * 提供视图层
     * @return
     */
    @Provides
    public RemoteImageContract.View provideView() {
        return mView;
    }

    /**
     * 提供model层
     * @return
     */
    @Provides
    public RemoteImageContract.Model provideModel(PretendBApi api) {
        return new RemoteImageModel(api);
    }


    /**
     * 提供一个适配器
     * @return
     */
    @Provides
    public PretendBAdapter provideAdapter() {
        return new PretendBAdapter();
    }

}
