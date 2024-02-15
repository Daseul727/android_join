package com.example.jointest.component.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.jointest.databinding.IncTitlebarBinding

class TitleBar : FrameLayout {
    constructor(context: Context) : super(context) {
        inflateView()
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        inflateView()
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        inflateView()
        initView()
    }

    private  var binding: IncTitlebarBinding? = null

    private fun inflateView() {
        binding = IncTitlebarBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    private fun initView() {
        //
    }

}