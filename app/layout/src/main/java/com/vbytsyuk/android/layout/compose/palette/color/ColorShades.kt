package com.vbytsyuk.android.layout.compose.palette.color

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color


class ColorShades(
    @ColorInt light: Long,
    @ColorInt normal: Long,
    @ColorInt dark: Long
) {
    val light = Color(light)
    val normal = Color(normal)
    val dark = Color(dark)
}
