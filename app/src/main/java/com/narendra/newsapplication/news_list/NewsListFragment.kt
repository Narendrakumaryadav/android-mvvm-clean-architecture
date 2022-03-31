package com.narendra.newsapplication.news_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.narendra.common.base.BaseFragment
import com.narendra.news_domain.model.dto.toNews
import com.narendra.news_domain.model.dto.toNewsDetails
import com.narendra.newsapplication.R
import com.narendra.newsapplication.databinding.FragmentNewsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListFragment : BaseFragment() {

    private var _binding: FragmentNewsListBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModel<NewsListViewModel>()
    private val newsListAdapter = NewsListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setTitle()
        setAdapter()
        initLoader()
        collectNews()
        onNewsListItemClickListener()
    }

    private fun onNewsListItemClickListener() {
        newsListAdapter.itemClickListener {
            val filterNews = viewModel.newsList.value.data?.filter { newsDataDto -> newsDataDto.title.equals(it.title) }
            val action = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment(filterNews!!.first().toNewsDetails())
            findNavController().navigate(action)
        }
    }

    private fun collectNews() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.newsList.collect { newsState ->
                if (newsState.isLoading) {
                    onLoadingDataReceived(true)
                }
                if (newsState.error.isNotBlank()) {
                    onLoadingDataReceived(false)
                    onErrorReceived(newsState.error)
                }
                newsState.data?.let {
                    if (it.isEmpty()) {
                        onErrorReceived(getString(R.string.no_data))
                    }
                    onLoadingDataReceived(false)
                    val newsList = it.map { it.toNews() }
                    newsListAdapter.setContentList(newsList.toMutableList())
                }
            }
        }
    }

    private fun setAdapter() {
        binding.newsRecycler.apply {
            adapter = newsListAdapter
        }
    }

    private fun setTitle() {
        activity?.title = getString(R.string.fragment_news_list_title)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}