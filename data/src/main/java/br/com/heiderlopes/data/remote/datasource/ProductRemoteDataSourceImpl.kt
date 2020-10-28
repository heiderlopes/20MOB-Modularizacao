package br.com.heiderlopes.data.remote.datasource

import br.com.heiderlopes.data.remote.api.ProductAPI
import br.com.heiderlopes.data.remote.mapper.ProductPayloadMapper
import br.com.heiderlopes.domain.entity.Product
import io.reactivex.Single

class ProductRemoteDataSourceImpl(private val productAPI: ProductAPI) : ProductRemoteDataSource {

    override fun getProducts(): Single<List<Product>> {
        return productAPI.getProducts().map { ProductPayloadMapper.map(it) }
    }
}
