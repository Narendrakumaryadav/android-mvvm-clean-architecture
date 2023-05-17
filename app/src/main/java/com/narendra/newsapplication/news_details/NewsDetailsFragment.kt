package com.narendra.newsapplication.news_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.navArgs
import com.narendra.common.base.BaseFragment
import com.narendra.newsapplication.R

/**
 * This fragment show selected news details
 */
internal class NewsDetailsFragment : BaseFragment() {

    private lateinit var composeView: ComposeView
//    private var _binding: FragmentNewsDetailsBinding? = null
//    private val binding: FragmentNewsDetailsBinding
//        get() = _binding!!

    private val args: NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
//        _binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
//        return _binding?.root
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setTitle()
//        bindNewsData()
        composeView.setContent {
            NewsDetailsScreen(newsDetails = args.selectedNewsDetails)
        }
    }

//    private fun bindNewsData() {
//        args.selectedNewsDetails.let {
//            binding.newsDetails = it
//        }
//    }

    private fun setTitle() {
        activity?.title = getString(R.string.fragment_news_details_title)
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}