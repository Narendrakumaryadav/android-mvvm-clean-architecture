package com.narendra.comman.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import java.util.*

class ActionButtonView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatButton(context, attrs, defStyleAttr) {
    override fun setText(text: CharSequence?, type: BufferType?) {
        val locale = Locale.getDefault()
        val capitalizedText = text?.toString()?.lowercase(locale)?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }
        super.setText(capitalizedText, type)
    }
}