package com.twilllnews.databinding;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.twilllnews.app.R;


/**
 * Created by Anil on 20/05/2017.
 */

public final class ImageBindingAdapter {

    @BindingAdapter(value = "url")
    public static void loadImageUrl(ImageView view, String url) {
        if (url != null && !url.equals(""))
           Glide.with(view.getContext())
                    .load(url)
                    .placeholder(R.drawable.place_holder)
                    .into(view);
    }

}
