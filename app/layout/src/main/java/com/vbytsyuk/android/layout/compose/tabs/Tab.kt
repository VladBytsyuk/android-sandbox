package com.vbytsyuk.android.layout.compose.tabs

import androidx.annotation.StringRes
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.geometry.Rect
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


@Preview @Composable private fun LightTab() = Tab(LightThemeAttributes, R.string.tab_account, isActive = true)
@Preview @Composable private fun DarkTab() = Tab(DarkThemeAttributes, R.string.tab_account, isActive = true)

@Composable
fun Tab(
    attr: ThemeAttributes,
    @StringRes titleId: Int,
    isActive: Boolean,
    modifier: Modifier = Modifier
) = ConstraintLayout {
    val (title, line) = createRefs()
    Text(
        text = stringResource(id = titleId).toUpperCase(),
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = attr.textColorBase
        ),
        modifier = Modifier
            .constrainAs(title) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            .padding(16.dp)
            .drawOpacity(0.87f)
    )
    if (isActive) Divider(
        color = attr.activeTabLineColor,
        thickness = 4.dp,
        modifier = Modifier
            .constrainAs(line) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
    )
}
