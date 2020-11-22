package com.vbytsyuk.android.layout.compose

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Preview @Composable private fun LightHeaderInfoBlockPreview() =
    HeaderInfo(LightThemeAttributes,
        ordersTitleId = R.string.header_orders_title, ordersValueId = R.string.header_orders_value,
        ratingTitleId = R.string.header_rating_title, ratingValueId = R.string.header_rating_value,
        purchasesTitleId = R.string.header_purchases_title, purchasesValueId = R.string.header_purchases_value,
    )
@Preview @Composable private fun DarkHeaderInfoBlockPreview() =
    HeaderInfo(DarkThemeAttributes,
        ordersTitleId = R.string.header_orders_title, ordersValueId = R.string.header_orders_value,
        ratingTitleId = R.string.header_rating_title, ratingValueId = R.string.header_rating_value,
        purchasesTitleId = R.string.header_purchases_title, purchasesValueId = R.string.header_purchases_value,
    )

@Composable
fun HeaderInfo(
    attr: ThemeAttributes,
    @StringRes ordersTitleId: Int, @StringRes ordersValueId: Int,
    @StringRes ratingTitleId: Int, @StringRes ratingValueId: Int,
    @StringRes purchasesTitleId: Int, @StringRes purchasesValueId: Int,
    modifier: Modifier = Modifier
) = Row(
    modifier = modifier.wrapContentSize()
) {
    HeaderInfoBlock(attr, titleId = ordersTitleId, valueId = ordersValueId)
    HeaderInfoBlock(attr, titleId = ratingTitleId, valueId = ratingValueId)
    HeaderInfoBlock(attr, titleId = purchasesTitleId, valueId = purchasesValueId)
}
