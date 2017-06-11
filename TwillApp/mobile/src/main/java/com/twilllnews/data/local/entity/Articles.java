package com.twilllnews.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.twilllnews.data.local.NewsApiTypeConverters;
import com.twilllnews.data.local.entity.Article;

import java.util.List;

/**
 * Created by Anil on 6/10/2017.
 */
@Entity(tableName = "Articles")
@TypeConverters(NewsApiTypeConverters.class)
public class Articles {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("status")
    private String status;

    @SerializedName("articles")
    private List<Article> articles;

    @SerializedName("source")
    private String source;

    @SerializedName("sortBy")
    private String sortBy;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", articles=" + articles +
                ", source='" + source + '\'' +
                ", sortBy='" + sortBy + '\'' +
                '}';
    }
}
