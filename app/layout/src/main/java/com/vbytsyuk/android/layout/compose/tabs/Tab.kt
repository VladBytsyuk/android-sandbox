package com.vbytsyuk.android.layout.compose.tabs

import androidx.annotation.StringRes
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Composable
fun Tab(
    attr: ThemeAttributes,
    @StringRes titleId: Int,
    isActive: Boolean,
    modifier: Modifier = Modifier
) = Surface(
    elevation = if (isActive) 4.dp else 0.dp,
    modifier = modifier
        .background(attr.screenBackground)
        .height(48.dp)
) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (bkg, title, line) = createRefs()
        Box(
            modifier = Modifier
                .drawOpacity(if (isActive) 1f else 0.87f)
                .background(attr.tabElementBackground)
                .fillMaxSize()
                .constrainAs(bkg) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = stringResource(id = titleId).toUpperCase(),
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = attr.textColorBase
            ),
            modifier = Modifier
                .drawOpacity(0.87f)
                .padding(16.dp)
                .constrainAs(title) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Divider(
            color = attr.activeTabLineColor,
            thickness = if (isActive) 4.dp else 0.dp,
            modifier = Modifier
                .constrainAs(line) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}


@Preview @Composable private fun LightActiveTab() = Tab(LightThemeAttributes, R.string.tab_account, isActive = true)
@Preview @Composable private fun DarkActiveTab() = Tab(DarkThemeAttributes, R.string.tab_account, isActive = true)
@Preview @Composable private fun LightInactiveTab() = Tab(LightThemeAttributes, R.string.tab_account, isActive = false)
@Preview @Composable private fun DarkInactiveTab() = Tab(DarkThemeAttributes, R.string.tab_account, isActive = false)
