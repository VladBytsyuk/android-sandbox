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
}


@Preview @Composable private fun LightTabBar() = TabsBar(LightThemeAttributes)
@Preview @Composable private fun DarkTabsBar() = TabsBar(DarkThemeAttributes)
