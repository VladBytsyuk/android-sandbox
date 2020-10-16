package com.vbytsyuk.android.core.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.vbytsyuk.android.core.appbar.AppBarConfigurator


abstract class CoreActivity(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {
    open val appBarConfigurator: AppBarConfigurator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        appBarConfigurator?.configure(this)
        setClickListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean =
        appBarConfigurator?.inflateMenu(menuInflater, menu) ?: super.onCreateOptionsMenu(menu)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val button: AppBarConfigurator.Button = appBarConfigurator?.menuMap?.find { it.menuItemId == item.itemId }
            ?: return super.onOptionsItemSelected(item)
        when (button) {
            is AppBarConfigurator.Button.Simple -> button.clickListener()
            is AppBarConfigurator.Button.Toggl -> {
                val newCheckedValue = !button.isChecked
                item.setIcon(if (newCheckedValue) button.checkedIconId else button.normalIconId)
                button.isChecked = newCheckedValue
                button.clickListener(newCheckedValue)
            }
        }
        return true
    }

    abstract fun setClickListeners()
}
