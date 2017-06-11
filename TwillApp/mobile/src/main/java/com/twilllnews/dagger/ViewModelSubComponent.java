package com.twilllnews.dagger;

import com.twilllnews.features.feeds.NewsSourcesListViewModel;

import dagger.Subcomponent;

/**
 * Created by Anil on 30/05/2017.
 */

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder{
        ViewModelSubComponent build();
    }

    NewsSourcesListViewModel  newsSourceseListViewModel();
}
