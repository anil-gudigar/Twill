package com.twilllnews.features.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.twilllnews.data.local.entity.Sources;
import com.twilllnews.data.remote.NewsAPIRepository;
import com.twilllnews.data.remote.Resource;

import javax.inject.Inject;


/**
 *  Created by Anil on 6/7/2017.
 */

public class NewsListViewModel extends ViewModel{
    private final NewsAPIRepository newsAPIRepository;

    @Inject
    public NewsListViewModel(NewsAPIRepository newsAPIRepository) {
        this.newsAPIRepository = newsAPIRepository;
    }

    public LiveData<Sources> getNewsSource(String id){
        return newsAPIRepository.getSource(id);
    }
}
