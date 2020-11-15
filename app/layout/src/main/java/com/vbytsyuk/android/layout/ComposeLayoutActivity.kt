package com.vbytsyuk.android.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


class ComposeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Root() }
    }
}

@Preview @Composable fun Preview() = Root()


@Composable fun Root() = ConstraintLayout {
    val (bkg, toolbar) = createRefs()
    Image(
        asset = imageResource(id = R.drawable.img_header_bkg_light),
        modifier = Modifier
            .preferredHeight(256.dp)
            .constrainAs(bkg) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
    )
    ToolBar(
        modifier = Modifier
            .preferredHeight(dimensionResource(id = R.dimen.tool_bar_height))
            .constrainAs(toolbar) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
    )
}


@Composable fun ToolBar(modifier: Modifier) = ConstraintLayout(modifier) {
    val (hamburger, title, logout) = createRefs()
    Image(
        asset = vectorResource(id = R.drawable.ic_toolbar_hamburger),
        modifier = Modifier
            .preferredSize(dimensionResource(id = R.dimen.tool_bar_icon_size))
            .constrainAs(hamburger) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
    )
}
