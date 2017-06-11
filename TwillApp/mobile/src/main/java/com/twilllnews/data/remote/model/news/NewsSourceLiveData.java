package com.twilllnews.data.remote.model.news;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.MainThread;
import android.util.Log;

/**
 * Created by Anil on 6/7/2017.
 */

public class NewsSourceLiveData extends LiveData<NewsSources> {
    private static NewsSourceLiveData sInstance;

    @MainThread
    public static NewsSourceLiveData get(Context context) {
        if (sInstance == null) {
            sInstance = new NewsSourceLiveData(context.getApplicationContext());
        }
        return sInstance;
    }

    @SuppressWarnings("MissingPermission")
    private NewsSourceLiveData(Context context) {
        Log.i("Twill", "NewsSourceLiveData -> created: ");
    }

    @Override
    protected void onActive() {
        Log.i("Twill", "NewsSourceLiveData -> onActive: ");
    }

    @Override
    protected void onInactive() {
        Log.i("Twill", "NewsSourceLiveData -> onInactive: ");
    }
}
