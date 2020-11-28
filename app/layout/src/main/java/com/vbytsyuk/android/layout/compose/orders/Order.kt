package com.vbytsyuk.android.layout.compose.orders

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Composable
fun Order(
    attr: ThemeAttributes,
    orderData: OrderData,
    modifier: Modifier = Modifier
) = ConstraintLayout(modifier = modifier) {

}


@Preview @Composable private fun LightOrderSuccessful() =
    Order(LightThemeAttributes, OrderData.Successful(number = 34567))
@Preview @Composable private fun DarkOrderSuccessful() =
    Order(DarkThemeAttributes, OrderData.Successful(number = 34567))

@Preview @Composable private fun LightOrderReturned() = Order(LightThemeAttributes, OrderData.Returned)
@Preview @Composable private fun DarkOrderReturned() = Order(DarkThemeAttributes, OrderData.Returned)

@Preview @Composable private fun LightOrderDiscount() = Order(LightThemeAttributes, OrderData.Discount)
@Preview @Composable private fun DarkOrderDiscount() = Order(DarkThemeAttributes, OrderData.Discount)
