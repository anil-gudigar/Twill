package com.twill.news.data.local;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.util.StringUtil;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.twill.news.app.constants.AppConstants;
import com.twill.news.data.local.entity.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anil on 6/10/2017.
 */

public class NewsApiTypeConverters {
    @TypeConverter
    public static List<Integer> stringToIntList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        return StringUtil.splitToIntList(data);
    }

    @TypeConverter
    public static String intListToString(List<Integer> ints) {
        return StringUtil.joinIntoString(ints);
    }

    @TypeConverter
    public static List<String> stringToStringList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(TextUtils.split(data, ","));
    }

    @TypeConverter
    public static String stringListToString(List<String> strings) {
        return TextUtils.join(", ", strings);
    }

    @TypeConverter
    public static List<Article> stringToArticalList(String data) {
        if (data == null || TextUtils.isEmpty(data)) {
            return Collections.emptyList();
        }
        List<Article> articles = new ArrayList<>();
        List<String> artcalString = Arrays.asList(TextUtils.split(data, "\t"));
        Gson gson = new Gson();
        for (String arti : artcalString) {
            Log.i(AppConstants.APP_TAG, "artical json :" + arti);
            Article article = gson.fromJson(arti, Article.class);
            articles.add(article);
        }
        return articles;
    }

    @TypeConverter
    public static String articalListToString(List<Article> articles) {
        if (articles == null) {
            return "";
        }
        Gson gson = new Gson();
        List<String> articalJsonList = new ArrayList<>();
        for (Article article : articles) {
            articalJsonList.add(gson.toJson(article));
        }
        return TextUtils.join("\t ", articalJsonList);
    }

}
