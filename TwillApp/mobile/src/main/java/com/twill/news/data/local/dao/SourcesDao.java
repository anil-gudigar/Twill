package com.twill.news.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.twill.news.data.local.entity.Sources;

import java.util.List;

/**
 * Created by Anil on 6/7/2017.
 */
@Dao
public interface SourcesDao {
    @Query("SELECT * FROM Sources ORDER BY category")
    LiveData<List<Sources>> loadSources();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveSources(List<Sources> SourcesEntities);

    @Query("SELECT * FROM Sources WHERE id=:id")
    LiveData<Sources> getSource(String id);
}
