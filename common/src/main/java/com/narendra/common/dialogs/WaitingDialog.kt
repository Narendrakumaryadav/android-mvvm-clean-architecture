package com.narendra.common.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Window
import com.narendra.common.utils.extensions.viewBinding
import com.narendra.common.R
import com.narendra.common.databinding.DialogWaitingBinding

/**
 * Manage waiting dialog popup
 */
class WaitingDialog(context: Context, val message: String, private val cancelListener: DialogInterface.OnCancelListener? = null) : Dialog(context, R.style.Dialog_Waiting) {

    private val binding by viewBinding(DialogWaitingBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        setCanceledOnTouchOutside(false)
        setOnCancelListener(cancelListener)
        binding.loadingText.text = message
    }
}
