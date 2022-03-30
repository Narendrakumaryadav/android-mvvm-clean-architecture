package com.narendra.newsapplication.di

import android.content.Context
import com.narendra.news_data.data.remote.NewsAPIService
import com.narendra.comman.helper.NetworkHelper
import com.narendra.comman.utils.constants.BASE_URL
import com.narendra.news_data.data.repository.NewsRepositoryImpl
import com.narendra.news_domain.repository.NewsRepository
import com.narendra.news_domain.use_case.NewsUseCase
import com.narendra.news_domain.use_case.NewsUseCaseImpl
import com.narendra.newsapplication.BuildConfig
import com.narendra.newsapplication.news_list.NewsListViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }

    single<NewsRepository> {
        return@single NewsRepositoryImpl(get())
    }
}
val useCaseModule = module {
    single<NewsUseCase> {
        return@single NewsUseCaseImpl(get())
    }
}
val viewModelModule = module {
    viewModel {
        NewsListViewModel(get())
    }
}
private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    } else OkHttpClient.Builder().build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient
    ): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): NewsAPIService =
    retrofit.create(NewsAPIService::class.java)