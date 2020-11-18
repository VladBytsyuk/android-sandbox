package com.vbytsyuk.android.layout.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily


@Composable
fun Theme(content: @Composable () -> Unit) =
    MaterialTheme(colors = Theme.Colors(), typography = Theme.Typography(), shapes = Theme.Shapes(), content = content)

private object Theme {
    @Composable fun Colors() = MaterialTheme.colors
    @Composable fun Typography() = MaterialTheme.typography
    @Composable fun Shapes() = MaterialTheme.shapes
}