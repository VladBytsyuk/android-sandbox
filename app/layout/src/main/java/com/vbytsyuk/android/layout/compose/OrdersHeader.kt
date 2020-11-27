package com.vbytsyuk.android.layout.compose

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Composable
fun OrdersHeader(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = ConstraintLayout(
    modifier = modifier.fillMaxWidth()
) {
    val (filter, icon, clear) = createRefs()
    Text(
        text = stringResource(id = R.string.tab_orders_header_picker),
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.sp,
            color = attr.textColorBase
        ),
        modifier = Modifier
            .drawOpacity(0.54f)
            .padding(16.dp)
            .constrainAs(filter) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
    )
    Icon(
        asset = vectorResource(id = R.drawable.ic_collapse_arrow),
        tint = attr.iconTint,
        modifier = Modifier
            .constrainAs(icon) {
                start.linkTo(filter.end)
                top.linkTo(filter.top)
                bottom.linkTo(filter.bottom)
            }
    )
    Text(
        text = stringResource(id = R.string.tab_orders_header_clear).toUpperCase(),
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = attr.textColorBase
        ),
        modifier = Modifier
            .drawOpacity(0.54f)
            .padding(16.dp)
            .constrainAs(clear) {
                end.linkTo(parent.end)
                baseline.linkTo(filter.baseline)
            }
    )
}

@Preview @Composable private fun LightOrdersHeader() = OrdersHeader(LightThemeAttributes)
@Preview @Composable private fun DarkOrdersHeader() = OrdersHeader(DarkThemeAttributes)
