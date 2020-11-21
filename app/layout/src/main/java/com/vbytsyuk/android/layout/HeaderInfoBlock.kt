package com.vbytsyuk.android.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Preview @Composable private fun LightHeaderInfoBlockPreview() = HeaderInfoBlock(LightThemeAttributes)
@Preview @Composable private fun DarkHeaderInfoBlockPreview() = HeaderInfoBlock(DarkThemeAttributes)

@Composable
fun HeaderInfoBlock(
    attr: ThemeAttributes,
    modifier: Modifier = Modifier
) = Column() {

}
