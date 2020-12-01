package com.vbytsyuk.android.layout.compose.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Composable
fun BottomBar(
    attr: ThemeAttributes,
    items: Map<Int, Int>,
    selectedIndex: Int,
    modifier: Modifier = Modifier
) = Row(
    modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(attr.bottomBarBackground)
) {
    items.entries.forEachIndexed { index, (icon, text) ->
        BottomBarItem(
            attr, iconId = icon, titleId = text, isSelected = index == selectedIndex,
            modifier = Modifier.width(108.dp)
        )
    }
}


@Preview @Composable fun LightBottomBar() = BottomBar(LightThemeAttributes, items, selectedIndex = 4)
@Preview @Composable fun DarkBottomBar() = BottomBar(DarkThemeAttributes, items, selectedIndex = 4)

private val items = mapOf(
    R.drawable.ic_bottom_bar_shopping to R.string.bottom_bar_tab_title_shopping,
    R.drawable.ic_bottom_bar_catalog to R.string.bottom_bar_tab_title_catalog,
    R.drawable.ic_bottom_bar_cart to R.string.bottom_bar_tab_title_cart,
    R.drawable.ic_bottom_bar_likes to R.string.bottom_bar_tab_title_likes,
    R.drawable.ic_bottom_bar_account to R.string.bottom_bar_tab_title_account,
)
