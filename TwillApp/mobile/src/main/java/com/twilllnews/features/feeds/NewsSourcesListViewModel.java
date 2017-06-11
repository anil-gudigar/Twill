package com.twilllnews.features.feeds;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.twilllnews.data.local.entity.Sources;
import com.twilllnews.data.remote.NewsAPIRepository;
import com.twilllnews.data.remote.Resource;

import java.util.List;

import javax.inject.Inject;


/**
 *  Created by Anil on 6/7/2017.
 */

public class NewsSourcesListViewModel extends ViewModel {
    private final LiveData<Resource<List<Sources>>> newsSources;

    @Inject
    public NewsSourcesListViewModel(NewsAPIRepository newsAPIRepository) {
        newsSources = newsAPIRepository.loadNewsSources();
    }

    LiveData<Resource<List<Sources>>> getNewsSources() {
        return newsSources;
    }
}
