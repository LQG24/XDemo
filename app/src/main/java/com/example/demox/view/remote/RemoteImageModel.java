package com.example.demox.view.remote;

import com.example.demox.data.api.PretendBApi;
import com.example.demox.data.bean.PretendBItem;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import retrofit2.Call;

/**
 * Created by jamin on 16-5-18.
 */
public class RemoteImageModel implements RemoteImageContract.Model {

    PretendBApi mPretendBApi;

    public RemoteImageModel(PretendBApi api) {
        this.mPretendBApi = api;
    }

    /**
     * 这里使用的是一个同步方法
     * @param keyword
     * @return
     * @throws IOException
     */
    @Override
    public List<PretendBItem> getDataFromWeb(String keyword) throws IOException {
        Call<List<PretendBItem> > listCall = mPretendBApi.search(keyword);
        return listCall.execute().body();
    }
}
