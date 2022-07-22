package br.com.cwi.nespresso_app.presentation.feature.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import br.com.cwi.nespresso_app.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(
    imageUrl: String?,
    @DrawableRes placeholderRes: Int = R.drawable.character,
    @DrawableRes imageErrorRes: Int = R.drawable.character
) {
    val requestOptions = RequestOptions().apply {
        placeholder(placeholderRes)
        error(imageErrorRes)
        transform(CenterCrop())
    }
    Glide.with(this.context)
        .setDefaultRequestOptions(requestOptions)
        .load(imageUrl)
        .into(this)
}
