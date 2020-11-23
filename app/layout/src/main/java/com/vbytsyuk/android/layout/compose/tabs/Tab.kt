package com.vbytsyuk.android.layout.compose.tabs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Preview @Composable fun LightTab() = Tab(LightThemeAttributes)
@Preview @Composable fun DarkTab() = Tab(DarkThemeAttributes)

@Composable
fun Tab(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) {

}
