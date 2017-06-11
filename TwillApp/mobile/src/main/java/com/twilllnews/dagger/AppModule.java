package com.twilllnews.dagger;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.twilllnews.app.BuildConfig;
import com.twilllnews.data.local.NewsAPIDatabase;
import com.twilllnews.data.local.dao.ArticlesDao;
import com.twilllnews.data.local.dao.SourcesDao;
import com.twilllnews.data.remote.NewsAPIDBService;
import com.twilllnews.data.remote.RequestInterceptor;
import com.twilllnews.viewmodel.news.NewsViewModelFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.twilllnews.app.constants.AppConstants.API_CONSTANTS.NEWS_API_BASE_URL;
import static com.twilllnews.app.constants.AppConstants.API_CONSTANTS.TIMEOUT_IN_SEC;

/**
 * Created by Anil on 20/05/2017.
 */
@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        okHttpClient.addInterceptor(logging);
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    NewsAPIDBService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NEWS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(NewsAPIDBService.class);
    }

    @Provides
    @Singleton
    NewsAPIDatabase provideNewsAPIDatabase(Application application) {
        return Room.databaseBuilder(application, NewsAPIDatabase.class, "newsapi.db").build();
    }

    @Provides
    @Singleton
    SourcesDao provideSourcesDao(NewsAPIDatabase newsAPIDatabase) {
        return newsAPIDatabase.sourcesDao();
    }
    @Provides
    @Singleton
    ArticlesDao provideArticlesDao(NewsAPIDatabase newsAPIDatabase) {
        return newsAPIDatabase.articlesDao();
    }
    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder builder){
        return new NewsViewModelFactory(builder.build());
    }

}
