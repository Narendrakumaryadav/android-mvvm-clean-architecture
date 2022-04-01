package com.narendra.news_domain.di

import com.narendra.news_domain.use_case.NewsUseCase
import com.narendra.news_domain.use_case.NewsUseCaseImpl
import org.koin.dsl.module

/**
 * all use case dependency
 */
val useCaseModule = module {
    single<NewsUseCase> {
        return@single NewsUseCaseImpl(get())
    }
}