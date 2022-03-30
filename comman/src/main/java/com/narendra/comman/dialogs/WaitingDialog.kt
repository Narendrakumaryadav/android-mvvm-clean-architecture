package com.narendra.comman.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Window
import com.narendra.comman.R
import com.narendra.comman.databinding.DialogWaitingBinding
import com.narendra.comman.utils.extensions.viewBinding

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
