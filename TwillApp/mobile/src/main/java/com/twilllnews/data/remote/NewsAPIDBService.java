package com.twilllnews.data.remote;

import com.twilllnews.app.constants.AppConstants;
import com.twilllnews.data.local.entity.Articles;
import com.twilllnews.data.remote.model.news.NewsSources;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anil on 6/7/2017.
 */

public interface NewsAPIDBService {

    @GET(AppConstants.API_CONSTANTS.REQUEST_NEWS_SOURCES)
    Call<NewsSources> loadNewsSources();

    @GET(AppConstants.API_CONSTANTS.REQUEST_NEWS_ARTICLES)
    Call<Articles> loadNewsArticles(@Query("source") String source);

}
