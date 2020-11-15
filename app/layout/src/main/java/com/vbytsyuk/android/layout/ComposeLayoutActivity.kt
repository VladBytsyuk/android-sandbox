package com.vbytsyuk.android.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class ComposeLayoutActivity : AppCompatActivity() {
    @Preview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello, World!")
        }
    }
}
