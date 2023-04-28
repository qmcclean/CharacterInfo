package com.example.characterinfo

import android.app.Application
import com.example.characterinfo.api.apiModule
import com.example.characterinfo.modules.repositoryModule
import com.example.characterinfo.network.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                apiModule,
                viewModelsModule,
                repositoryModule
            )
        }
    }
}