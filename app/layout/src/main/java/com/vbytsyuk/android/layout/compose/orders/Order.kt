package com.vbytsyuk.android.layout.compose.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Composable
fun Order(
    attr: ThemeAttributes,
    orderData: OrderData,
    modifier: Modifier = Modifier
) = ConstraintLayout(modifier = modifier.fillMaxWidth().wrapContentSize()) {
    val (image, title, message, details) = createRefs()
    Image(
        asset = when (orderData) {
            is OrderData.Successful -> vectorResource(id = R.drawable.ic_list_item_cart)
            OrderData.Returned -> vectorResource(id = R.drawable.ic_list_item_return)
            OrderData.Discount -> vectorResource(id = R.drawable.ic_list_item_discount)
        },
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .size(40.dp)
            .constrainAs(image) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
    )
    Image(
        asset = vectorResource(id = R.drawable.ic_details_arrow),
        modifier = Modifier
            .padding(all = 8.dp)
            .size(40.dp)
            .constrainAs(details) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
    )
}


@Preview @Composable private fun LightOrderSuccessful() =
    Order(LightThemeAttributes, OrderData.Successful(number = 34567))
@Preview @Composable private fun DarkOrderSuccessful() =
    Order(DarkThemeAttributes, OrderData.Successful(number = 34567))

@Preview @Composable private fun LightOrderReturned() = Order(LightThemeAttributes, OrderData.Returned)
@Preview @Composable private fun DarkOrderReturned() = Order(DarkThemeAttributes, OrderData.Returned)

@Preview @Composable private fun LightOrderDiscount() = Order(LightThemeAttributes, OrderData.Discount)
@Preview @Composable private fun DarkOrderDiscount() = Order(DarkThemeAttributes, OrderData.Discount)
