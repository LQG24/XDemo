package com.example.demox.view.remote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.demox.R;
import com.example.demox.data.bean.PretendBItem;
import com.example.demox.view.adapter.PretendBAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by chan on 2016/5/18.
 */
public class RemoteImageFragment extends Fragment implements RemoteImageContract.View {

    PretendBAdapter mAdapter;

    RemoteImageContract.Presenter mPresenter;

    @BindView(R.id.et_key_2_search_remote)
    AppCompatEditText etKey2Search;
    @BindView(R.id.empty_view_remote)
    TextView emptyView;
    @BindView(R.id.rv_pretend_b_remote)
    RecyclerView rvPretendB;

    public static RemoteImageFragment newInstance() {
        Bundle args = new Bundle();
        RemoteImageFragment fragment = new RemoteImageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new PretendBAdapter();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remote, container, false);
        ButterKnife.bind(this, view);
        rvPretendB.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvPretendB.setAdapter(mAdapter);
        return view;
    }

    @OnClick(R.id.bt_submit_query_remote)
    public void onClick() {
        mPresenter.requestAndShowImage();
    }

    @OnEditorAction(R.id.et_key_2_search_remote)
    public boolean onEditDone(KeyEvent event) {
        if (event.getAction() == EditorInfo.IME_ACTION_SEARCH) {
            mPresenter.requestAndShowImage();
        }
        return true;
    }

    /**
     * 获取输入
     *
     * @return
     */
    @Override
    public String getQueryKey() {
        return etKey2Search.getText().toString();
    }

    /**
     * 刷新数据
     *
     * @param itemList
     */
    @Override
    public void refreshListView(List<PretendBItem> itemList) {
        if (itemList == null || itemList.size() == 0) {
            showTip("找不到相关图片");
            return;
        }

        emptyView.setVisibility(View.GONE);
        mAdapter.setItems(itemList);
    }

    @Override
    public void showTip(String tip) {
        emptyView.setVisibility(View.VISIBLE);
        emptyView.setText(tip);
    }

    @Override
    public void setPresenter(@NonNull RemoteImageContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }
}
