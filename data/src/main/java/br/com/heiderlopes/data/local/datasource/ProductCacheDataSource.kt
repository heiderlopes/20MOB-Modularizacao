package br.com.heiderlopes.data.local.datasource

import br.com.heiderlopes.domain.entity.Product
import io.reactivex.Single

interface ProductCacheDataSource {

    fun getProducts() : Single<List<Product>>

    fun insertData(products: List<Product>)

    fun updateData(products: List<Product>)

}