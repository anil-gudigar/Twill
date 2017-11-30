package com.twill.news.features;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 *  Created by Anil on 6/7/2017.
 */

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type>{

    public abstract void setData(List<Data> data);
}
