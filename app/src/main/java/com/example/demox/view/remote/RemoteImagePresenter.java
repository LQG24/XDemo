package com.example.demox.view.remote;

import android.os.AsyncTask;

import com.example.demox.data.bean.PretendBItem;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by jamin on 16-5-20.
 */
public class RemoteImagePresenter implements RemoteImageContract.Presenter {
    private RemoteImageContract.Model mModel;
    private RemoteImageContract.View mView;

    /**
     * 当RemoteImagePresenter被@Inject声明时，若没有对应的Provider方法，那么会使用这个构造方法，
     * 构造方法中的参数由Module里的Provider方法提供
     * @param model
     * @param view
     */
    @Inject
    public RemoteImagePresenter(RemoteImageContract.Model model, RemoteImageContract.View view) {
        this.mModel = model;
        this.mView = view;
    }

    /**
     *这个方法会紧接着构造函数之后被调用
     */
    @Inject
    void setupListener() {
        mView.setPresenter(this);
    }

    @Override
    public void requestAndShowImage() {
        final String keyWord = mView.getQueryKey();
        new AsyncTask<Void, Void, List<PretendBItem>>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mView.showTip("正在搜索,请稍等...");
            }

            @Override
            protected List<PretendBItem> doInBackground(Void... params) {
                List<PretendBItem> items = null;
                try {
                    //请求数据
                    items =  mModel.getDataFromWeb(keyWord);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return items;
            }

            @Override
            protected void onPostExecute(List<PretendBItem> items) {
                mView.refreshListView(items);
            }
        }.execute();
    }

    @Override
    public void start() {
        //做一些初始化动作
        mView.showTip("开始装逼吧！");
    }

}
