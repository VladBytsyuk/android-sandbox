package com.vbytsyuk.android.layout.compose.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Icon(
        asset = vectorResource(id = iconId),
        tint = if (isSelected) attr.bottomBarIconTintEnabled else attr.bottomBarIconTintDisabled,
        modifier = Modifier
            .size(24.dp)
            .align(Alignment.CenterHorizontally)
    )
    if (isSelected) Text(
        text = stringResource(id = titleId),
        style = TextStyle(
            fontSize = 14.sp,
            color = attr.textColorBase
        ),
        modifier = Modifier
            .drawOpacity(0.87f)
            .align(Alignment.CenterHorizontally)
    )
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
