package com.twill.news.features.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.twill.news.data.local.entity.Articles;
import com.twill.news.features.BaseAdapter;
import com.twill.news.databinding.ItemNewsarticleListBinding;
import com.twill.news.data.local.entity.Article;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anil on 6/7/2017.
 */

public class NewsArticleListAdapter extends BaseAdapter<NewsArticleListAdapter.ArticleViewHolder, Articles> {

    private List<Articles> newArticleEntities;

    private final NewsArticleListCallback newsListCallback;

    public NewsArticleListAdapter(@NonNull NewsArticleListCallback newsListCallback) {
        newArticleEntities = new ArrayList<>();
        this.newsListCallback = newsListCallback;
    }

    @Override
    public void setData(List<Articles> articleEntities) {
        this.newArticleEntities = articleEntities;
        notifyDataSetChanged();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return ArticleViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, newsListCallback);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder viewHolder, int i) {
        if (null != newArticleEntities && newArticleEntities.size() > 0 && null != newArticleEntities.get(0).getArticles()) {
            Article article = newArticleEntities.get(0).getArticles().get(i);
            if (null != article)
                viewHolder.onBind(article);
        }
    }

    @Override
    public int getItemCount() {
        if (null != newArticleEntities && newArticleEntities.size() > 0 && null != newArticleEntities.get(0).getArticles()) {
            return newArticleEntities.get(0).getArticles().size();
        } else {
            return 0;
        }
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {

        public static ArticleViewHolder create(LayoutInflater inflater, ViewGroup parent, NewsArticleListCallback callback) {
            ItemNewsarticleListBinding itemNewsarticleListBinding = ItemNewsarticleListBinding.inflate(inflater, parent, false);
            return new ArticleViewHolder(itemNewsarticleListBinding, callback);
        }

        ItemNewsarticleListBinding binding;

        public ArticleViewHolder(ItemNewsarticleListBinding binding, NewsArticleListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v ->
                    callback.onNewsArticleClicked(binding.getArticle(), binding.imageViewCover));
        }

        public void onBind(Article article) {
            binding.setArticle(article);
            binding.executePendingBindings();
        }
    }
}
