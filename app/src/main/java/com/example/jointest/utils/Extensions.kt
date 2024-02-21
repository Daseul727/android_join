package com.example.jointest.utils

import android.content.Context
import android.view.View
import com.example.jointest.component.widget.WidgetToast
import com.example.jointest.utils.base.OnOneOffClickListener

/**
 * 중복클릭 방지
 */
fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    try {
        val safeClickListener = OnOneOffClickListener {
            onSafeClick(it)
        }
        setOnClickListener(safeClickListener)
    } catch (E: Exception) {
    }
}

/**
 * 토스트
 */
fun Context.showToast(message: String) {
    WidgetToast.createToast(this, message)?.show()
}