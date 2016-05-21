package com.example.demox.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demox.R;
import com.example.demox.data.bean.PretendBItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jamin on 16-5-20.
 */
public class PretendBAdapter extends RecyclerView.Adapter<PretendBAdapter.PretendBViewHolder> {
    private List<PretendBItem> items;

    public PretendBAdapter() {
    }

    @Override
    public PretendBViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pretendb_image, parent, false);
        return new PretendBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PretendBViewHolder holder, int position) {
        PretendBItem item = items.get(position);
        Glide.with(holder.ivImage.getContext()).load(item.getImage_url()).into(holder.ivImage);
        holder.tvDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setItems(List<PretendBItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class PretendBViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item_pretend)
        ImageView ivImage;

        @BindView(R.id.tv_item_pretend_description)
        TextView tvDescription;

        public PretendBViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
