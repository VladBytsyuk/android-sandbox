package com.vbytsyuk.android.layout.compose.tabs

import androidx.annotation.StringRes
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R
import com.vbytsyuk.android.layout.compose.DarkThemeAttributes
import com.vbytsyuk.android.layout.compose.LightThemeAttributes
import com.vbytsyuk.android.layout.compose.ThemeAttributes


@Preview @Composable private fun LightTab() = Tab(LightThemeAttributes, R.string.tab_account)
@Preview @Composable private fun DarkTab() = Tab(DarkThemeAttributes, R.string.tab_account)

@Composable
fun Tab(
    attr: ThemeAttributes,
    @StringRes titleId: Int,
    modifier: Modifier = Modifier
) = ConstraintLayout {
    val (title, line) = createRefs()
    Text(
        text = stringResource(id = titleId)
    )
}
