package com.twilllnews.data.remote;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.twilllnews.app.constants.AppConstants;
import com.twilllnews.data.local.dao.ArticlesDao;
import com.twilllnews.data.local.dao.SourcesDao;
import com.twilllnews.data.local.entity.Articles;
import com.twilllnews.data.local.entity.Sources;
import com.twilllnews.data.remote.model.news.NewsSources;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by Anil on 6/7/2017.
 */

public class NewsAPIRepository {
    private final ArticlesDao articlesDao;
    private final SourcesDao sourcesDao;
    private final NewsAPIDBService newsAPIDBService;

    @Inject
    public NewsAPIRepository(ArticlesDao articlesDao, SourcesDao sourcesDao, NewsAPIDBService newsAPIDBServic) {
        this.articlesDao = articlesDao;
        this.sourcesDao = sourcesDao;
        this.newsAPIDBService = newsAPIDBServic;
    }

    public LiveData<Resource<List<Sources>>> loadNewsSources() {
        return new NetworkBoundResource<List<Sources>, NewsSources>() {

            @Override
            protected void saveCallResult(@NonNull NewsSources item) {
               List<Sources> sourceslist = item.getSources();
                for (Sources sources:sourceslist) {
                    if(TextUtils.isEmpty(sources.getUrlsToLogos().getMedium())){
                        String url = AppConstants.NewsSourceLogo.get(sources.getId());
                        if(null != url){
                            sources.getUrlsToLogos().setMedium(url);
                        }
                    }
                }
                sourcesDao.saveSources(sourceslist);
            }

            @NonNull
            @Override
            protected LiveData<List<Sources>> loadFromDb() {
                return sourcesDao.loadSources();
            }

            @NonNull
            @Override
            protected Call<NewsSources> createCall() {
                return newsAPIDBService.loadNewsSources();
            }
        }.getAsLiveData();
    }

    public LiveData<Sources> getSource(String id){
        return sourcesDao.getSource(id);
    }


    public LiveData<Resource<List<Articles>>> loadNewsArticles(String source) {
        return new NetworkBoundResource<List<Articles>, Articles>() {

            @Override
            protected void saveCallResult(@NonNull Articles item) {
                articlesDao.saveArticles(item);
            }

            @NonNull
            @Override
            protected LiveData<List<Articles>> loadFromDb() {
                return articlesDao.getArticles(source);
            }

            @NonNull
            @Override
            protected Call<Articles> createCall() {
                return newsAPIDBService.loadNewsArticles(source);
            }
        }.getAsLiveData();
    }

    public LiveData<List<Articles>> getArticle(String source){
        return articlesDao.getArticles(source);
    }
}
