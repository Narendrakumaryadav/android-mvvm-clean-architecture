package com.narendra.common.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.narendra.common.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
    val options = RequestOptions.placeholderOf(R.drawable.ic_image_place_holder).error(com.google.android.material.R.drawable.mtrl_ic_error)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}