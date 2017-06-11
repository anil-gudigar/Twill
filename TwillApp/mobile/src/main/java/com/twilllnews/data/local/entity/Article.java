package com.twilllnews.data.local.entity;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Anil on 6/10/2017.
 */
public class Article {
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("urlToImage")
    private String urlToImage;


    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return this.urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getpublishedDateFormatted(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
        SimpleDateFormat correctformate = new SimpleDateFormat("yyyy-MM-dd HH:mm ", Locale.ENGLISH);
        String dateString = "";
        try {
            Date date = sdf.parse(publishedAt);
            dateString= correctformate.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dateString;
    }
    @Override
    public String toString() {
        return "{" +
                "author:\"" + author + '\"' +
                ", title:\"" + title + '\"' +
                ", description:\"" + description + '\"' +
                ", url:\"" + url + '\"' +
                ", publishedAt:\"" + publishedAt + '\"' +
                ", urlToImage:\"" + urlToImage + '\"' +
                '}';
    }
}
