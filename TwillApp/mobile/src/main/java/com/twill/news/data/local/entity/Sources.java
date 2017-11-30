package com.twill.news.data.local.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.twill.news.data.local.NewsApiTypeConverters;

import java.util.List;

/**
 * Created by Anil on 6/7/2017.
 */
@Entity(indices = {@Index("id"), @Index("category")},tableName = "Sources")
@TypeConverters(NewsApiTypeConverters.class)
public class Sources {
    @PrimaryKey
    @SerializedName("id")
    private String id;

    @SerializedName("category")
    private String category;

    @Embedded
    @SerializedName("urlsToLogos")
    private UrlsToLogos urlsToLogos;

    @SerializedName("description")
    private String description;

    @SerializedName("sortBysAvailable")
    private List<String> sortBysAvailable;

    @SerializedName("name")
    private String name;

    @SerializedName("language")
    private String language;

    @SerializedName("url")
    private String url;

    @SerializedName("country")
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public UrlsToLogos getUrlsToLogos ()
    {
        return urlsToLogos;
    }

    public void setUrlsToLogos (UrlsToLogos urlsToLogos)
    {
        this.urlsToLogos = urlsToLogos;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }


    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public void setSortBysAvailable(List<String> sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
    }

    @Override
    public String toString() {
        return "Sources{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", urlsToLogos=" + urlsToLogos +
                ", description='" + description + '\'' +
                ", sortBysAvailable=" + sortBysAvailable +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", url='" + url + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
