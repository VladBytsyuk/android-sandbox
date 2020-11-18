package com.vbytsyuk.android.layout.compose

import android.graphics.drawable.Drawable
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun Theme(content: @Composable () -> Unit) = MaterialTheme(
    colors = MaterialTheme.colors,
    typography = Theme.typography(),
    shapes = Theme.shapes(),
    content = content
)

enum class ThemeMode { LIGHT, DARK }

interface ThemeAttributes {
    val disabledBackground: Color
    val enabledBackground: Color

    val bottomBarIconTintDisabled: Color
    val bottomBarIconTintEnabled: Color

    val activeTabLineColor: Color

    val headerBackgroundDrawable: Drawable
    val iconTint: Color

    val textColorBase: Color
    val textColorSuccess: Color
    val textColorFailure: Color

    val screenBackground: Color get() = disabledBackground
    val appBarBackground: Color get() = enabledBackground
    val bottomBarBackground: Color get() = enabledBackground
    val tabElementBackground: Color get() = enabledBackground
    val tabContentBackground: Color get() = enabledBackground
}

private object Theme {
    @Composable fun typography() = MaterialTheme.typography
    @Composable fun shapes() = MaterialTheme.shapes
}
