package com.narendra.newsapplication.di

import com.narendra.newsapplication.news_list.NewsListViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

/**
 * all view model dependency
 */

val viewModelModule = module {
    viewModel {
        NewsListViewModel(get())
    }
}
