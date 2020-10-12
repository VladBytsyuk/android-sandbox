package com.vbytsyuk.android.glide

import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.mvi.CoreMviActivity
import com.vbytsyuk.android.core.pictures.ImageLoader


class GlideActivity : CoreMviActivity<GlideState, GlideInteractor>(
    layoutId = R.layout.activity_glide_main
) {
    override val interactor: GlideInteractor by viewModels()
    private val imageLoader: ImageLoader = GlideImageLoader(context = this)

    private val imageView: ImageView by lazyFindViewById(R.id.agmImageView)
    private val buttonClear: Button by lazyFindViewById(R.id.agmBtnClear)
    private val buttonLocal: Button by lazyFindViewById(R.id.agmBtnLocal)
    private val buttonRemote: Button by lazyFindViewById(R.id.agmBtnRemote)

    override fun render(state: GlideState): Any? = when (state) {
        GlideState.Empty ->
            imageLoader.clear(view = imageView)

        is GlideState.LocalDrawable ->
            imageLoader.load(drawableId = state.drawableId, intoView = imageView)

        is GlideState.RemoteImage ->
            imageLoader.load(imageUrl = state.url, intoView = imageView)
    }

    override fun setClickListeners() {
        buttonClear.setOnClickListener { interactor.tapOnClear() }
        buttonLocal.setOnClickListener { interactor.tapOnLoadLocal() }
        buttonRemote.setOnClickListener { interactor.tapOnLoadRemote() }
    }
}
