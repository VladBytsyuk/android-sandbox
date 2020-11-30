package com.vbytsyuk.android.layout.compose.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Composable
fun BottomBarItem(
    attr: ThemeAttributes,
    @DrawableRes iconId: Int,
    @StringRes titleId: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) = Column(modifier = modifier) {

}

@Preview @Composable fun LightActiveBottomBarItem() = BottomBarItem(
    attr = LightThemeAttributes,
    iconId = R.drawable.ic_bottom_bar_account, titleId = R.string.bottom_bar_tab_title_account,
    isSelected = true
)
@Preview @Composable fun DarkActiveBottomBarItem() = BottomBarItem(
    attr = DarkThemeAttributes,
    iconId = R.drawable.ic_bottom_bar_account, titleId = R.string.bottom_bar_tab_title_account,
    isSelected = true
)
@Preview @Composable fun LightInactiveBottomBarItem() = BottomBarItem(
    attr = LightThemeAttributes,
    iconId = R.drawable.ic_bottom_bar_account, titleId = R.string.bottom_bar_tab_title_account,
    isSelected = false
)
@Preview @Composable fun DarkInactiveBottomBarItem() = BottomBarItem(
    attr = DarkThemeAttributes,
    iconId = R.drawable.ic_bottom_bar_account, titleId = R.string.bottom_bar_tab_title_account,
    isSelected = false
)
