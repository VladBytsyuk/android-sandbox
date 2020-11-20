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
        val (bkg, toolbar) = createRefs()
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
    }
}
