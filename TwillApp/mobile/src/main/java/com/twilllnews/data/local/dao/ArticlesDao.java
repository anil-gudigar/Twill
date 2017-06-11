package com.twilllnews.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.twilllnews.data.local.entity.Article;
import com.twilllnews.data.local.entity.Article;
import com.twilllnews.data.local.entity.Articles;

import java.util.List;

/**
 * Created by Anil on 6/7/2017.
 */
@Dao
public interface ArticlesDao {
    @Query("SELECT * FROM Articles")
    LiveData<List<Articles>> loadArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveArticles(Articles ArticleEntities);

    @Query("SELECT * FROM Articles WHERE source=:source")
    LiveData<List<Articles>> getArticles(String source);

}
