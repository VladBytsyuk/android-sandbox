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
import com.vbytsyuk.android.layout.compose.header.HeaderInfo
import com.vbytsyuk.android.layout.compose.Theme
import com.vbytsyuk.android.layout.compose.ThemeMode
import com.vbytsyuk.android.layout.compose.ToolBar


class ComposeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Root(ThemeMode.LIGHT) }
    }
}

@Preview @Composable fun LightActivityPreview() = Root(ThemeMode.LIGHT)
@Preview @Composable fun DarkActivityPreview() = Root(ThemeMode.DARK)


@Composable fun Root(mode: ThemeMode) = Theme(mode) { attr ->
    ConstraintLayout(
        modifier = Modifier.background(attr.screenBackground)
    ) {
        val (bkg, toolbar, avatar, headerInfo) = createRefs()
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
    }
}
