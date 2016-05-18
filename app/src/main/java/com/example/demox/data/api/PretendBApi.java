package com.example.demox.data.api;

import com.example.demox.data.bean.PretendBItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chan on 2016/5/18.
 */
public interface PretendBApi {
    @GET("/search")
    Call<List<PretendBItem>> search(@Query("q") String key);
}
