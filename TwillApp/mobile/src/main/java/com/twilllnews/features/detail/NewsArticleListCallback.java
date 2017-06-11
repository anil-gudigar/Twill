package com.twilllnews.features.detail;

import android.view.View;

import com.twilllnews.data.local.entity.Article;
import com.twilllnews.data.local.entity.Articles;
import com.twilllnews.data.local.entity.Sources;


/**
 *  Created by Anil on 6/7/2017.
 */

public interface NewsArticleListCallback {
    void onNewsArticleClicked(Article article, View sharedView);
}
