package com.vbytsyuk.android.layout.compose

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
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

private object Theme {
    @Composable fun typography() = MaterialTheme.typography
    @Composable fun shapes() = MaterialTheme.shapes
}

enum class ThemeMode { LIGHT, DARK }

interface ThemeAttributes {
    val disabledBackground: Color
    val enabledBackground: Color

    val bottomBarIconTintDisabled: Color
    val bottomBarIconTintEnabled: Color

    val activeTabLineColor: Color

    val headerBackgroundDrawableId: Int
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

object LightThemeAttributes : ThemeAttributes {
    override val disabledBackground = Color(0x000000)
    override val enabledBackground = Color(0x000000)
    override val bottomBarIconTintDisabled = Color(0x000000)
    override val bottomBarIconTintEnabled = Color(0x000000)
    override val activeTabLineColor = Color(0x000000)
    override val headerBackgroundDrawableId = 0
    override val iconTint = Color(0x000000)
    override val textColorBase = Color(0x000000)
    override val textColorSuccess = Color(0x000000)
    override val textColorFailure = Color(0x000000)
}

object DarkThemeAttributes : ThemeAttributes {
    override val disabledBackground = Color(0x000000)
    override val enabledBackground = Color(0x000000)
    override val bottomBarIconTintDisabled = Color(0x000000)
    override val bottomBarIconTintEnabled = Color(0x000000)
    override val activeTabLineColor = Color(0x000000)
    override val headerBackgroundDrawableId = 0
    override val iconTint = Color(0x000000)
    override val textColorBase = Color(0x000000)
    override val textColorSuccess = Color(0x000000)
    override val textColorFailure = Color(0x000000)
}