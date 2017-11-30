package com.twill.news.data.remote;

import com.twill.news.data.local.entity.Articles;
import com.twill.news.app.constants.AppConstants;
import com.twill.news.data.remote.model.news.NewsSources;

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
