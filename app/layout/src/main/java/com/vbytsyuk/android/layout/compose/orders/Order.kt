package com.vbytsyuk.android.layout.compose.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
) = ConstraintLayout(
    modifier = modifier
        .background(attr.enabledBackground)
        .fillMaxWidth()
        .wrapContentHeight()
) {
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
    Text(
        text = when (orderData) {
            is OrderData.Successful -> stringResource(id = R.string.order_title_regular_template).format(orderData.number)
            OrderData.Returned -> stringResource(id = R.string.order_title_discount)
            OrderData.Discount -> stringResource(id = R.string.order_title_return)
        },
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
        ),
        color = attr.textColorBase,
        modifier = Modifier
            .fillMaxWidth()
            .drawOpacity(0.87f)
            .constrainAs(title) {
                start.linkTo(image.end)
                top.linkTo(image.top)
                end.linkTo(details.start)
            }
    )
    Text(
        text = when (orderData) {
            OrderData.Returned -> stringResource(id = R.string.order_status_unsuccessful)
            else -> stringResource(id = R.string.order_status_successful)
        },
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.sp,
        ),
        color = attr.textColorBase,
        modifier = Modifier
            .fillMaxWidth()
            .drawOpacity(0.54f)
            .constrainAs(message) {
                start.linkTo(title.end)
                top.linkTo(title.bottom)
                end.linkTo(title.start)
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
