package com.twill.news.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Anil on 6/7/2017.
 */
@Entity(tableName = "UrlsToLogos")
public class UrlsToLogos {
    @PrimaryKey(autoGenerate = true)
    private int urlid;

    @SerializedName("small")
    private String small;

    @SerializedName("large")
    private String large;

    @SerializedName("medium")
    private String medium;

    public UrlsToLogos() {
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getUrlid() {
        return urlid;
    }

    public void setUrlid(int urlid) {
        this.urlid = urlid;
    }

    @Override
    public String toString() {
        return "UrlsToLogos{" +
                "urlid=" + urlid +
                ", small='" + small + '\'' +
                ", large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
