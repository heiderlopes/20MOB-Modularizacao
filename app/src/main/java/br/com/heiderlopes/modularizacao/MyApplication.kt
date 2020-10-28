package br.com.heiderlopes.modularizacao

import android.app.Application
import br.com.heiderlopes.data.di.dataModules
import br.com.heiderlopes.domain.di.domainModule
import br.com.heiderlopes.modularizacao.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@MyApplication)

            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}