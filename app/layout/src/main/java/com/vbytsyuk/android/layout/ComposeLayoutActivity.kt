package com.vbytsyuk.android.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.compose.ToolBar


class ComposeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Root() }
    }
}

@Preview @Composable fun Preview() = Root()


@Composable fun Root() = ConstraintLayout() {
    val (bkg, toolbar) = createRefs()
    Image(
        asset = imageResource(id = R.drawable.img_header_bkg_light),
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
        modifier = Modifier
            .constrainAs(toolbar) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
    )

}
