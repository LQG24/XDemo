package com.example.demox.view.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demox.R;
import com.example.demox.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chan on 2016/5/18.
 */
public class WebFragment extends BaseFragment {

    @BindView(R.id.et_key_2_search_web)
    AppCompatEditText etKey2SearchWeb;
    @BindView(R.id.bt_submit_query_web)
    AppCompatButton btSubmitQueryWeb;
    @BindView(R.id.rv_pretend_b_web)
    RecyclerView rvPretendBWeb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void setUpActivityComponent() {

    }

    @OnClick(R.id.bt_submit_query_web)
    public void onClick() {

    }
}
