package com.twilllnews.dagger;

import com.twilllnews.features.detail.NewsStoryActivity;
import com.twilllnews.features.feeds.HomeActivity;
import com.twilllnews.features.detail.NewsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Anil on 30/05/2017.
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract HomeActivity homeActivity();

    @ContributesAndroidInjector
    abstract NewsListActivity newsListActivity();

    @ContributesAndroidInjector
    abstract NewsStoryActivity newsStoryActivity();
}
