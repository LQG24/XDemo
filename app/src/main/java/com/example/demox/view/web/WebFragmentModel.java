package com.example.demox.view.web;

import com.example.demox.data.api.PretendBApi;
import com.example.demox.data.bean.PretendBItem;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Created by jamin on 16-5-18.
 */
public class WebFragmentModel implements WebFragmentContract.Model {

    PretendBApi mPretendBApi;

    @Override
    public List<PretendBItem> getDataFromWeb(String keyword) throws IOException {
        Call<List<PretendBItem> > listCall = mPretendBApi.search(keyword);
        return listCall.execute().body();
    }
}
