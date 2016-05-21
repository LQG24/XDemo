package com.example.demox.view.remote;

import com.example.demox.base.BasePresenter;
import com.example.demox.base.BaseView;
import com.example.demox.data.bean.PretendBItem;

import java.io.IOException;
import java.util.List;

/**
 * Created by chan on 2016/5/18.
 */
public interface RemoteImageContract {

    interface View extends BaseView<Presenter>{

        /**
         * 获取用户的输入值：搜索的关键字
         * @return
         */
        String getQueryKey();

        /**
         * 刷新列表数据
         */
        void refreshListView(List<PretendBItem> itemList);

        void showTip(String tip);
    }

    interface Model{

        /**
         * 从网络获取数据
         * @return
         */
        List<PretendBItem> getDataFromWeb(String keyword) throws IOException;
    }

    interface Presenter extends BasePresenter{

        /**
         * 展示从网络上获取的图片
         */
        void requestAndShowImage();
    }

}
