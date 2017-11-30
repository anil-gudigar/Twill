package com.twill.news.features.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.twill.news.data.local.entity.Articles;
import com.twill.news.data.remote.NewsAPIRepository;
import com.twill.news.data.remote.Resource;

import java.util.List;

import javax.inject.Inject;


/**
 *  Created by Anil on 6/7/2017.
 */

public class NewsArticleListViewModel extends ViewModel {
    private NewsAPIRepository newsAPIRepository;
    @Inject
    public NewsArticleListViewModel(NewsAPIRepository newsAPIRepository) {
        this.newsAPIRepository = newsAPIRepository;
    }

    public LiveData<Resource<List<Articles>>> getNewsArticles(String source) {
        LiveData<Resource<List<Articles>>> newsArticles = newsAPIRepository.loadNewsArticles(source);
        return newsArticles;
    }
}
