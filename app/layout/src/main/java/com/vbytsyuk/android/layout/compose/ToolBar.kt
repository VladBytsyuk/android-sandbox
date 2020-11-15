package com.vbytsyuk.android.layout.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import com.vbytsyuk.android.layout.R


@Preview
@Composable
fun ToolBar(
    modifier: Modifier
) = ConstraintLayout(modifier) {
    val (hamburger, title, logout) = createRefs()
    Image(
        asset = vectorResource(id = R.drawable.ic_toolbar_hamburger),
        modifier = Modifier
            .preferredSize(dimensionResource(id = R.dimen.tool_bar_icon_size))
            .constrainAs(hamburger) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
    )
    Text(
        text = stringResource(id = R.string.toolbar_name),
        modifier = Modifier
            .constrainAs(title) {
                start.linkTo(hamburger.end)
                top.linkTo(parent.top)
                end.linkTo(logout.start)
                bottom.linkTo(parent.bottom)
            }
    )
    Image(
        asset = vectorResource(id = R.drawable.ic_toolbar_logout),
        modifier = Modifier
            .preferredSize(dimensionResource(id = R.dimen.tool_bar_icon_size))
            .constrainAs(logout) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
    )
}
