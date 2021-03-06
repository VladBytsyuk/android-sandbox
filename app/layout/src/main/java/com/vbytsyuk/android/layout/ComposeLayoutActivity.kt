package com.vbytsyuk.android.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.core.Theme.*
import com.vbytsyuk.android.core.controllers.ThemeController
import com.vbytsyuk.android.layout.compose.orders.OrdersHeader
import com.vbytsyuk.android.layout.compose.header.HeaderInfo
import com.vbytsyuk.android.layout.compose.Theme
import com.vbytsyuk.android.layout.compose.ThemeMode
import com.vbytsyuk.android.layout.compose.ToolBar
import com.vbytsyuk.android.layout.compose.bottombar.BottomBar
import com.vbytsyuk.android.layout.compose.orders.OrderData
import com.vbytsyuk.android.layout.compose.orders.OrdersList
import com.vbytsyuk.android.layout.compose.tabs.TabsBar
import org.koin.android.ext.android.inject


class ComposeLayoutActivity : AppCompatActivity() {
    private val themeController: ThemeController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val themeMode = when (themeController.currentTheme) {
            BY_SYSTEM -> ThemeMode.LIGHT
            LIGHT -> ThemeMode.LIGHT
            DARK -> ThemeMode.DARK
        }
        setContent { Root(themeMode) }
    }
}


@Composable fun Root(mode: ThemeMode) = Theme(mode) { attr ->
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(attr.screenBackground)
    ) {
        val (bkg, toolbar, avatar, headerInfo, tabs, spacer, ordersHeader, ordersList, bottomBar) = createRefs()
        Image(
            asset = imageResource(id = attr.headerBackgroundDrawableId),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(256.dp)
                .constrainAs(bkg) {
                    start.linkTo(toolbar.start)
                    top.linkTo(toolbar.top)
                    end.linkTo(toolbar.end)
                }
                .fillMaxWidth()
        )
        ToolBar(
            attr = attr,
            modifier = Modifier
                .constrainAs(toolbar) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )
        Image(
            asset = imageResource(id = R.drawable.img_header_avatar),
            modifier = Modifier
                .padding(top = dimensionResource (id = R.dimen.header_avatar_margin))
                .size(dimensionResource(id = R.dimen.header_avatar_size))
                .constrainAs(avatar) {
                    start.linkTo(parent.start)
                    top.linkTo(toolbar.bottom)
                    end.linkTo(parent.end)
                }
        )
        HeaderInfo(
            attr = attr,
            ordersTitleId = R.string.header_orders_title, ordersValueId = R.string.header_orders_value,
            ratingTitleId = R.string.header_rating_title, ratingValueId = R.string.header_rating_value,
            purchasesTitleId = R.string.header_purchases_title, purchasesValueId = R.string.header_purchases_value,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.header_title_margin_top))
                .constrainAs(headerInfo) {
                    start.linkTo(parent.start)
                    top.linkTo(avatar.bottom)
                    end.linkTo(parent.end)
                }
        )
        TabsBar(
            attr = attr,
            modifier = Modifier
                .constrainAs(tabs) {
                    start.linkTo(parent.start)
                    top.linkTo(bkg.bottom)
                    end.linkTo(parent.end)
                }
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
                .constrainAs(spacer) {
                    start.linkTo(parent.start)
                    top.linkTo(tabs.bottom)
                    end.linkTo(parent.end)
                }
        )
        OrdersHeader(
            attr = attr,
            modifier = Modifier
                .constrainAs(ordersHeader) {
                    start.linkTo(parent.start)
                    top.linkTo(spacer.bottom)
                    end.linkTo(parent.end)
                }
        )
        OrdersList(
            attr = attr,
            orderDataList = listOf(
                OrderData.Successful(34567),
                OrderData.Successful(34567),
                OrderData.Discount,
                OrderData.Returned
            ),
            modifier = Modifier
                .constrainAs(ordersList) {
                    start.linkTo(parent.start)
                    top.linkTo(ordersHeader.bottom)
                    end.linkTo(parent.end)
                }
        )
        BottomBar(
            attr = attr,
            items = mapOf(
                R.drawable.ic_bottom_bar_shopping to R.string.bottom_bar_tab_title_shopping,
                R.drawable.ic_bottom_bar_catalog to R.string.bottom_bar_tab_title_catalog,
                R.drawable.ic_bottom_bar_cart to R.string.bottom_bar_tab_title_cart,
                R.drawable.ic_bottom_bar_likes to R.string.bottom_bar_tab_title_likes,
                R.drawable.ic_bottom_bar_account to R.string.bottom_bar_tab_title_account,
            ),
            selectedIndex = 4,
            modifier = Modifier
                .constrainAs(bottomBar) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )
    }
}


@Preview @Composable fun LightActivityPreview() = Root(ThemeMode.LIGHT)
@Preview @Composable fun DarkActivityPreview() = Root(ThemeMode.DARK)
