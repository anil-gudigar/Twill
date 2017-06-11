package com.twilllnews.features.feeds;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.twilllnews.app.databinding.ItemNewssourceListBinding;
import com.twilllnews.data.local.entity.Sources;
import com.twilllnews.features.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anil on 6/7/2017.
 */

public class NewsListAdapter extends BaseAdapter<NewsListAdapter.SourceViewHolder, Sources> {

    private List<Sources> newSourceEntities;

    private final NewsListCallback newsListCallback;

    public NewsListAdapter(@NonNull NewsListCallback newsListCallback) {
        newSourceEntities = new ArrayList<>();
        this.newsListCallback = newsListCallback;
    }

    @Override
    public void setData(List<Sources> sourceEntities) {
        this.newSourceEntities = sourceEntities;
        notifyDataSetChanged();
    }

    @Override
    public SourceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return SourceViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, newsListCallback);
    }

    @Override
    public void onBindViewHolder(SourceViewHolder viewHolder, int i) {
        Sources sources = newSourceEntities.get(i);
        viewHolder.onBind(sources);
    }

    @Override
    public int getItemCount() {
        return newSourceEntities.size();
    }

    static class SourceViewHolder extends RecyclerView.ViewHolder {

        public static SourceViewHolder create(LayoutInflater inflater, ViewGroup parent, NewsListCallback callback) {
            ItemNewssourceListBinding itemNewssourceListBinding = ItemNewssourceListBinding.inflate(inflater, parent, false);
            return new SourceViewHolder(itemNewssourceListBinding, callback);
        }

        ItemNewssourceListBinding binding;

        public SourceViewHolder(ItemNewssourceListBinding binding, NewsListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v ->
                    callback.onNewsSourceClicked(binding.getSources(), binding.imageViewCover));
        }

        public void onBind(Sources sources) {
            binding.setSources(sources);
            binding.executePendingBindings();
        }
    }
}
