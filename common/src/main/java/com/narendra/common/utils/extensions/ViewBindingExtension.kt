package com.narendra.common.utils.extensions

import android.app.Dialog
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> Dialog.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }
