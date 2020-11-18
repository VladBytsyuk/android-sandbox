package com.vbytsyuk.android.layout.compose.colors

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color


interface MaterialPalette {
    val _50: MaterialColor
    val _100: MaterialColor
    val _200: MaterialColor
    val _300: MaterialColor
    val _400: MaterialColor
    val _500: MaterialColor
    val _600: MaterialColor
    val _700: MaterialColor
    val _800: MaterialColor
    val _900: MaterialColor

    val _a100: MaterialColor
    val _a200: MaterialColor
    val _a400: MaterialColor
    val _a700: MaterialColor
}

class MaterialColor(
    @ColorInt light: Int,
    @ColorInt normal: Int,
    @ColorInt dark: Int
) {
    val light = Color(light)
    val normal = Color(normal)
    val dark = Color(dark)
}
