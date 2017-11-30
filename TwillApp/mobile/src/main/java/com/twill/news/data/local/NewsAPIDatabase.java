package com.twill.news.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.twill.news.data.local.dao.ArticlesDao;
import com.twill.news.data.local.entity.Articles;
import com.twill.news.data.local.entity.Sources;
import com.twill.news.data.local.dao.SourcesDao;

/**
 * Created by Anil on 6/7/2017.
 */
@Database(entities = {Sources.class, Articles.class}, version = 2)
public abstract class NewsAPIDatabase extends RoomDatabase {

    public abstract SourcesDao sourcesDao();

    public abstract ArticlesDao articlesDao();

}
