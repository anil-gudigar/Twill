package com.twilllnews.features.feeds;

import android.view.View;

import com.twilllnews.data.local.entity.Sources;


/**
 *  Created by Anil on 6/7/2017.
 */

public interface NewsListCallback {
    void onNewsSourceClicked(Sources sources, View sharedView);
}
