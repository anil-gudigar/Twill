package com.twilllnews.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.twilllnews.data.local.dao.ArticlesDao;
import com.twilllnews.data.local.dao.SourcesDao;
import com.twilllnews.data.local.entity.Article;
import com.twilllnews.data.local.entity.Articles;
import com.twilllnews.data.local.entity.Sources;
import com.twilllnews.data.local.entity.UrlsToLogos;

/**
 * Created by Anil on 6/7/2017.
 */
@Database(entities = {Sources.class, Articles.class}, version = 2)
public abstract class NewsAPIDatabase extends RoomDatabase {

    public abstract SourcesDao sourcesDao();

    public abstract ArticlesDao articlesDao();

}
