package com.narendra.newsapplication

import android.app.Application
import com.narendra.newsapplication.di.appModule
import com.narendra.newsapplication.di.useCaseModule
import com.narendra.newsapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
/**
 * Application class that initialize koin
 */
class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@NewsApplication)
            modules(listOfNotNull(appModule, useCaseModule, viewModelModule))
        }
    }
}