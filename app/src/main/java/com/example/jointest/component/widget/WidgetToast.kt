package com.example.jointest.component.widget

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.jointest.R
import com.example.jointest.databinding.WidgetToastBinding
import com.orhanobut.logger.Logger

object WidgetToast {
    fun createToast(context: Context, message: String?): Toast? {
        val inflater = LayoutInflater.from(context)
        val binding: WidgetToastBinding =
            DataBindingUtil.inflate(inflater, R.layout.widget_toast, null, false)

        var convertMsg = ""
        var convertMsg1 = ""
        var convertMsg2 = ""
        var convertMsg3 = ""
        var convertMsg4 = ""
        var convertMsg5 = ""
        if (!message.isNullOrEmpty()) {
            convertMsg = message.replace("\n","1111")
            convertMsg1 = message.replace("₩n", "2222")
            convertMsg2 = message.replace("\\r\\n", "3333");
            convertMsg3 = message.replace("\\n", "4444");
            convertMsg4 = message.replace("\\r", "5555");
            convertMsg5 = message.replace("\\\\n", "6666");
        }

        val msg = "$message|$convertMsg|$convertMsg1|$convertMsg2|$convertMsg3|$convertMsg4|$convertMsg5"
        Logger.d("TOAST: $msg")

        val msg2 = message?.let{
            it.replace("\\n", "\n");
        }
        binding.tvMsg.text = msg2  ?: "Error"

        return Toast(context).apply {
            setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 16.toPx())
            duration = Toast.LENGTH_SHORT
            view = binding.root
        }
    }

    private fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
}