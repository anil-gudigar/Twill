package com.twilllnews.data.remote.model.news;

import com.twilllnews.data.local.entity.Sources;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Anil on 6/7/2017.
 */

public class NewsSources {
    private String status;

    private List<Sources> sources;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public List<Sources> getSources() {
        return sources;
    }

    public void setSources(List<Sources> sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "NewsSources{" +
                "status='" + status + '\'' +
                ", sources=" + sources +
                '}';
    }
}
