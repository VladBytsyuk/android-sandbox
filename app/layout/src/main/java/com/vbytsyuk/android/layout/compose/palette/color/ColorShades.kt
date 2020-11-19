package com.vbytsyuk.android.layout.compose.palette.color

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color


class ColorShades(
    @ColorInt light: Int,
    @ColorInt normal: Int,
    @ColorInt dark: Int
) {
    val light = Color(light)
    val normal = Color(normal)
    val dark = Color(dark)
}
