package br.com.heiderlopes.data.remote.datasource

import br.com.heiderlopes.domain.entity.Product
import io.reactivex.Single

interface ProductRemoteDataSource {
    fun getProducts() : Single<List<Product>>
}
