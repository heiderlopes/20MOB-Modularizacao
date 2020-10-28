package br.com.heiderlopes.domain.repository

import br.com.heiderlopes.domain.entity.Product
import io.reactivex.Single

interface ProductRepository {

    fun getProducts(forceUpdate: Boolean) : Single<List<Product>>

}