package com.twill.news.features.detail;

import android.view.View;

import com.twill.news.data.local.entity.Article;


/**
 *  Created by Anil on 6/7/2017.
 */

public interface NewsArticleListCallback {
    void onNewsArticleClicked(Article article, View sharedView);
}
