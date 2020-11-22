package com.vbytsyuk.android.layout.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Preview @Composable private fun LightToolBarPreview() = ToolBar(LightThemeAttributes)
@Preview @Composable private fun DarkToolBarPreview() = ToolBar(DarkThemeAttributes)

@Composable
fun ToolBar(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = Surface(
    elevation = 4.dp,
    modifier = modifier.height(dimensionResource(id = R.dimen.tool_bar_height))
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .background(attr.appBarBackground)
    ) {
        Image(
            asset = vectorResource(id = R.drawable.ic_toolbar_hamburger),
            colorFilter = ColorFilter.tint(attr.iconTint),
            modifier = Modifier
                .padding(8.dp)
                .preferredSize(dimensionResource(id = R.dimen.tool_bar_icon_size))
        )
        Text(
            text = stringResource(id = R.string.toolbar_name),
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            color = attr.textColorBase,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
                .drawOpacity(0.87f)
        )
        Image(
            asset = vectorResource(id = R.drawable.ic_toolbar_logout),
            colorFilter = ColorFilter.tint(attr.iconTint),
            modifier = Modifier
                .padding(8.dp)
                .preferredSize(dimensionResource(id = R.dimen.tool_bar_icon_size))
        )
    }
}
