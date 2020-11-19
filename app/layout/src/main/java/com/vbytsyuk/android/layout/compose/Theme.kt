package com.vbytsyuk.android.layout.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vbytsyuk.android.layout.R
import com.vbytsyuk.android.layout.compose.palette.MaterialPalette


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
    override val disabledBackground = MaterialPalette.BlueGrey._50.normal
    override val enabledBackground = MaterialPalette.White
    override val bottomBarIconTintDisabled = MaterialPalette.Grey._600.normal
    override val bottomBarIconTintEnabled = MaterialPalette.Black
    override val activeTabLineColor = MaterialPalette.Green._a400.normal
    override val headerBackgroundDrawableId = R.drawable.img_header_bkg_light
    override val iconTint = MaterialPalette.Grey._600.normal
    override val textColorBase = MaterialPalette.Black
    override val textColorSuccess = MaterialPalette.Green._700.normal
    override val textColorFailure = MaterialPalette.Red._a400.normal
}

object DarkThemeAttributes : ThemeAttributes {
    override val disabledBackground = MaterialPalette.Black
    override val enabledBackground = MaterialPalette.BlueGrey._900.dark
    override val bottomBarIconTintDisabled = MaterialPalette.Grey._400.normal
    override val bottomBarIconTintEnabled = MaterialPalette.White
    override val activeTabLineColor = MaterialPalette.Green._a400.dark
    override val headerBackgroundDrawableId = R.drawable.img_header_bkg_light
    override val iconTint = MaterialPalette.Grey._400.normal
    override val textColorBase = MaterialPalette.White
    override val textColorSuccess = MaterialPalette.Green._700.light
    override val textColorFailure = MaterialPalette.Red._a400.light
}
