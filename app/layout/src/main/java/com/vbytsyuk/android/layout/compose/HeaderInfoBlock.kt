package com.vbytsyuk.android.layout.compose

import androidx.annotation.StringRes
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Preview @Composable private fun LightHeaderInfoBlockPreview() =
    HeaderInfoBlock(LightThemeAttributes, R.string.header_orders_title, R.string.header_orders_value)
@Preview @Composable private fun DarkHeaderInfoBlockPreview() =
    HeaderInfoBlock(DarkThemeAttributes, R.string.header_orders_title, R.string.header_orders_value)

@Composable
fun HeaderInfoBlock(
    attr: ThemeAttributes,
    @StringRes titleId: Int,
    @StringRes valueId: Int,
    modifier: Modifier = Modifier
) = Column(
    modifier = modifier.wrapContentHeight()
) {
    Text(
        text = stringResource(id = titleId),
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        ),
        color = attr.textColorBase,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .drawOpacity(0.54f)
    )
    Text(
        text = stringResource(id = valueId),
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        ),
        color = attr.textColorBase,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .drawOpacity(0.87f)
    )
}
