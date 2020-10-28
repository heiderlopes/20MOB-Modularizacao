package br.com.heiderlopes.data.di

import br.com.heiderlopes.data.local.database.ProductsDatabase
import br.com.heiderlopes.data.local.datasource.ProductCacheDataSource
import br.com.heiderlopes.data.local.datasource.ProductCacheDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module {

    single { ProductsDatabase.createDatabase(androidContext()) }

    factory<ProductCacheDataSource> { ProductCacheDataSourceImpl(productDao = get())  }

}
