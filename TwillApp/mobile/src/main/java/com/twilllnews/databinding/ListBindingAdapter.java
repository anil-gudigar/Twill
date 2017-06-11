package com.twilllnews.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.twilllnews.data.remote.Resource;
import com.twilllnews.features.BaseAdapter;

import java.util.List;


/**
 * Created by Anil on 6/7/2017.
 */

public final class ListBindingAdapter{
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }
}
