package com.example.demox.view.web;

import com.example.demox.data.bean.PretendBItem;

import java.util.List;

/**
 * Created by chan on 2016/5/18.
 */
public interface WebFragmentContract {

    interface View{

        /**
         * 获取用户的输入值：搜索的关键字
         * @return
         */
        String getQueryKey();

        /**
         * 刷新列表数据
         */
        void refreshListview(List<PretendBItem> itemList);
    }

    interface Presenter{

        /**
         * 展示从网络上获取的图片
         */
        void showImageFromWeb();
    }

}
