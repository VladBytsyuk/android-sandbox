package com.vbytsyuk.android.layout.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vbytsyuk.android.layout.R


@Composable
fun Theme(mode: ThemeMode, content: @Composable (ThemeAttributes) -> Unit) = MaterialTheme(
    colors = MaterialTheme.colors,
    typography = Theme.typography(),
    shapes = Theme.shapes(),
    content = {
        val attributes = when (mode) {
            ThemeMode.LIGHT -> LightThemeAttributes
            ThemeMode.DARK -> DarkThemeAttributes
        }
        content(attributes)
    }
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
    override val disabledBackground = Color(0xeceff1)
    override val enabledBackground = Color(0xffffff)
    override val bottomBarIconTintDisabled = Color(0x757575)
    override val bottomBarIconTintEnabled = Color(0x000000)
    override val activeTabLineColor = Color(0x00e676)
    override val headerBackgroundDrawableId = R.drawable.img_header_bkg_light
    override val iconTint = Color(0x757575)
    override val textColorBase = Color(0x000000)
    override val textColorSuccess = Color(0x388e3c)
    override val textColorFailure = Color(0xff1744)
}

object DarkThemeAttributes : ThemeAttributes {
    override val disabledBackground = Color(0x000000)
    override val enabledBackground = Color(0x000a12)
    override val bottomBarIconTintDisabled = Color(0xbdbdbd)
    override val bottomBarIconTintEnabled = Color(0xffffff)
    override val activeTabLineColor = Color(0x00b248)
    override val headerBackgroundDrawableId = R.drawable.img_header_bkg_dark
    override val iconTint = Color(0xbdbdbd)
    override val textColorBase = Color(0xffffff)
    override val textColorSuccess = Color(0x6abf69)
    override val textColorFailure = Color(0xff616f)
}