package com.twill.news.features.detail;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.twill.news.data.local.entity.Article;
import com.twill.news.R;
import com.twill.news.app.constants.AppConstants;
import com.twill.news.databinding.ActivityNewsStoryBinding;

import dagger.android.AndroidInjection;

public class NewsStoryActivity extends AppCompatActivity {

    private static final String KEY_NEWARTICLE_DATA = "key_newsarticle_data";
    ActivityNewsStoryBinding binding;

    public static Intent newIntent(Context context, String sourceId) {
        Intent intent = new Intent(context, NewsStoryActivity.class);
        intent.putExtra(KEY_NEWARTICLE_DATA, sourceId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setTranslucentStatusBar(getWindow());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_story);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String newsarticle = getIntent().getStringExtra(KEY_NEWARTICLE_DATA);
        Log.i(AppConstants.APP_TAG, "newsarticle :" + newsarticle);
        Gson gson = new Gson();
        Article article = gson.fromJson(newsarticle, Article.class);
        binding.setArticle(article);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public static void setTranslucentStatusBar(Window window) {
        if (window == null) return;
        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt >= Build.VERSION_CODES.LOLLIPOP) {
            setTranslucentStatusBarLollipop(window);
        } else if (sdkInt >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatusBarKiKat(window);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static void setTranslucentStatusBarLollipop(Window window) {
        window.setStatusBarColor(
                window.getContext()
                        .getResources()
                        .getColor(android.R.color.transparent));
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static void setTranslucentStatusBarKiKat(Window window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
