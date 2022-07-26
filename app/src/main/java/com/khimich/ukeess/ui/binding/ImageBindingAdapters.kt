package com.khimich.ukeess.ui.binding

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.khimich.ukeess.R

object ImageBindingAdapters {
    @JvmStatic
    @BindingAdapter("setImageUrl")
    fun bindingImageUrl(imageView: ImageView, imageUrl: String?) {
        imageUrl?.let {
                Glide.with(imageView)
                    .load(Uri.parse(imageUrl))
                    .error(R.drawable.user)
                    .placeholder(R.drawable.user)
                    .into(imageView)
        }
    }
}