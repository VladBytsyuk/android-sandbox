package com.vbytsyuk.android.layout.compose.tabs

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Composable
fun TabsBar(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = Row {
    Tab(attr, titleId = R.string.tab_account, isActive = false, modifier = Modifier.width(108.dp))
    Tab(attr, titleId = R.string.tab_orders, isActive = true, modifier = Modifier.weight(1f))
}


@Preview @Composable private fun LightTabBar() = TabsBar(LightThemeAttributes)
@Preview @Composable private fun DarkTabsBar() = TabsBar(DarkThemeAttributes)
