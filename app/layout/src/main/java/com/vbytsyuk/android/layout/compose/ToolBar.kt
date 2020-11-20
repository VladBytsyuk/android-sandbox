package com.vbytsyuk.android.layout.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Preview @Composable private fun LightToolBarPreview() = ToolBar(LightThemeAttributes)
@Preview @Composable private fun DarkToolBarPreview() = ToolBar(DarkThemeAttributes)

@Composable
fun ToolBar(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = Surface(elevation = 4.dp) {
    Row(modifier = modifier.background(attr.appBarBackground)) {
        Image(
            asset = vectorResource(id = R.drawable.ic_toolbar_hamburger),
            colorFilter = ColorFilter.tint(attr.iconTint),
            modifier = Modifier
                .preferredSize(dimensionResource(id = R.dimen.tool_bar_icon_size))
                .padding(8.dp)
        )
        Text(
            text = stringResource(id = R.string.toolbar_name),
            style = Text.AppBar.Title,
            color = attr.textColorBase,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        )
        Image(
            asset = vectorResource(id = R.drawable.ic_toolbar_logout),
            colorFilter = ColorFilter.tint(attr.iconTint),
            modifier = Modifier
                .preferredSize(dimensionResource(id = R.dimen.tool_bar_icon_size))
                .padding(8.dp)
        )
    }
}
