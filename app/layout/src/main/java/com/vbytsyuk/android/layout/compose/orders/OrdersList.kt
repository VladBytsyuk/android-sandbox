package com.vbytsyuk.android.layout.compose.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Composable
fun OrdersList(
    attr: ThemeAttributes,
    orderDataList: List<OrderData>,
    modifier: Modifier = Modifier
) = Column(modifier = modifier.background(attr.enabledBackground)) {
    Spacer(modifier = Modifier.height(16.dp))
    orderDataList.forEach { data ->
        Order(attr, data)
        Spacer(modifier = Modifier.height(8.dp))
    }
    Spacer(modifier = Modifier.height(8.dp))
}


@Preview @Composable fun LightOrdersList() = OrdersList(
    LightThemeAttributes,
    orderDataList = listOf(
        OrderData.Successful(34567),
        OrderData.Successful(34567),
        OrderData.Discount,
        OrderData.Returned
    )
)

@Preview @Composable fun DarkOrdersList() = OrdersList(
    DarkThemeAttributes,
    orderDataList = listOf(
        OrderData.Successful(34567),
        OrderData.Successful(34567),
        OrderData.Discount,
        OrderData.Returned
    )
)
