package com.example.demox.data.model;

import com.example.demox.data.api.PretendBApi;
import com.example.demox.data.bean.PretendBItem;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by chan on 2016/5/18.
 */
public class ImageRepository {

    @Inject
    public List<PretendBItem> getImageFromWeb(PretendBApi api, String keyword) throws IOException {
        Call<List<PretendBItem>> call = api.search(keyword);
        return call.execute().body();
    }
}
