package com.narendra.common.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.StringRes
import com.narendra.common.utils.extensions.viewBinding
import com.narendra.common.R
import com.narendra.common.databinding.DialogErrorBinding

class ErrorDialog constructor(context: Context) : Dialog(context, R.style.AppTheme_NewDialog) {
    var message: CharSequence? = null
    var mainActionLabel: CharSequence? = null
    var startBold: Int = -1
    var endBold: Int = -1
    private var title: CharSequence? = null
    private var canceledOnTouchOutside = false

    private val binding by viewBinding(DialogErrorBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        setCancelable(true)
        setCanceledOnTouchOutside(true)

        if (!message.isNullOrEmpty()) {
            if (startBold != -1 && endBold != -1) {
                binding.dialogContentText.text = SpannableString(message).apply {
                    setSpan(StyleSpan(Typeface.BOLD), startBold, endBold, 0)
                }
            } else {
                binding.dialogContentText.text = message
            }
        }

        if (!title.isNullOrEmpty()) {
            binding.dialogTitle.text = title
        }

        binding.dialogMainAction.text = mainActionLabel
        binding.dialogMainAction.setOnClickListener {
            this@ErrorDialog.cancel()
        }


        binding.dialogContainer.setOnTouchListener { _, _ -> canceledOnTouchOutside }
        (binding.dialogContainer.parent as ViewGroup).setOnTouchListener { _, _ ->
            if (canceledOnTouchOutside)
                dismiss()
            true
        }
    }


    fun setMessage(@StringRes messageId: Int) {
        message = context.getText(messageId)
    }

    fun setMessage( errorMessage: String) {
        message = errorMessage
    }

    override fun setTitle(title: CharSequence?) {
        this.title = title
    }

    override fun setCanceledOnTouchOutside(cancel: Boolean) {
        super.setCanceledOnTouchOutside(cancel)
        canceledOnTouchOutside = cancel
    }

}