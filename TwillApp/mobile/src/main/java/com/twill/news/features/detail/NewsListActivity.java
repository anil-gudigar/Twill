package com.twill.news.features.detail;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.twill.news.data.local.entity.Article;
import com.twill.news.R;
import com.twill.news.databinding.ActivityNewssourceDetailBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by Anil on 19/05/2017.
 */

public class NewsListActivity extends AppCompatActivity implements LifecycleRegistryOwner,NewsArticleListCallback {

    private static final String KEY_NEWSSOURCE_ID = "key_newssource_id";

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    ActivityNewssourceDetailBinding binding;

    @Inject
    NewsListViewModel newsListViewModel;

    @Inject
    NewsArticleListViewModel newsArticleListViewModel;

    public static Intent newIntent(Context context, String sourceId) {
        Intent intent = new Intent(context, NewsListActivity.class);
        intent.putExtra(KEY_NEWSSOURCE_ID, sourceId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_newssource_detail);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String newsSourceId = getIntent().getStringExtra(KEY_NEWSSOURCE_ID);
        newsListViewModel.getNewsSource(newsSourceId)
                .observe(this, Source -> binding.setSources(Source));

        newsArticleListViewModel.getNewsArticles(newsSourceId)
                .observe(this, Articles -> binding.setResource(Articles));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new NewsArticleListAdapter(this));
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityCompat.finishAfterTransition(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    public void onNewsArticleClicked(Article article, View sharedView) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, sharedView, getString(R.string.article_shared_image));
        Gson gson = new Gson();
        String articalJson = gson.toJson(article);
        startActivity(NewsStoryActivity.newIntent(this, articalJson), options.toBundle());
    }
}
