package com.vbytsyuk.android.layout.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.res.stringResource
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Preview @Composable private fun LightHeaderInfoBlockPreview() = HeaderInfoBlock(LightThemeAttributes)
@Preview @Composable private fun DarkHeaderInfoBlockPreview() = HeaderInfoBlock(DarkThemeAttributes)

@Composable
fun HeaderInfoBlock(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = Column() {
    Text(
        text = stringResource(id = R.string.header_orders_title),
        style = Text.AppBar.Title,
        color = attr.textColorBase,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .weight(1f)
            .drawOpacity(0.54f)
    )
}
