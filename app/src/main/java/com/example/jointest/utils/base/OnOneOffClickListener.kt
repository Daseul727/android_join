package com.example.jointest.utils.base

import android.os.SystemClock
import android.view.View

class OnOneOffClickListener(
    private var defaultInterval: Int = 900,
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener {
    private var lastTimeClicked: Long = 0

    override fun onClick(v: View?) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v!!)
    }


}