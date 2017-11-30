package com.twilllnews.data.remote;

import android.support.annotation.NonNull;

import com.twilllnews.app.constants.AppConstants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *  Created by Anil on 6/7/2017.
 */

public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("apiKey", AppConstants.API_CONSTANTS.NEWS_API_KEY)
                .build();

        Request request = originalRequest.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
