package com.vbytsyuk.android.layout.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview


@Composable
fun OrdersHeader(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = Row {

}

@Preview @Composable private fun LightOrdersHeader() = OrdersHeader(LightThemeAttributes)
@Preview @Composable private fun DarkOrdersHeader() = OrdersHeader(DarkThemeAttributes)
