package com.narendra.common.base

import androidx.fragment.app.Fragment
import com.narendra.common.dialogs.ErrorDialog
import com.narendra.common.dialogs.WaitingDialog
import com.narendra.common.R

/**
 * Base class for all Fragments
 */
open class BaseFragment : Fragment() {

    private lateinit var loader: WaitingDialog

    fun initLoader() {
        loader = WaitingDialog(requireContext(), getString(R.string.data_loading))
    }

    fun onLoadingDataReceived(isLoading: Boolean) {
        if (isLoading) loader.show() else loader.dismiss()
    }

    fun onErrorReceived(errorMessage: String) {
        ErrorDialog(requireContext()).apply {
            setMessage(errorMessage)
            setTitle(R.string.error_title)
        }.show()
    }
}