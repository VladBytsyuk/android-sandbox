package com.vbytsyuk.android.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.compose.ToolBar


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
            .preferredWidth(0.dp)
            .zIndex(4f)
            .background(colorResource(id = R.color.white))
            .preferredHeight(dimensionResource(id = R.dimen.tool_bar_height))
            .constrainAs(toolbar) {
                start.linkTo(bkg.start)
                top.linkTo(bkg.top)
                end.linkTo(bkg.end)
            }
    )
}
