package com.vbytsyuk.android.layout.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Composable
fun OrdersHeader(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = ConstraintLayout() {
    val (filter, icon, clear) = createRefs()
    Text(
        text = stringResource(id = R.string.tab_orders_header_picker),
        modifier = Modifier
            .padding(16.dp)
            .constrainAs(filter) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
    )
}

@Preview @Composable private fun LightOrdersHeader() = OrdersHeader(LightThemeAttributes)
@Preview @Composable private fun DarkOrdersHeader() = OrdersHeader(DarkThemeAttributes)
