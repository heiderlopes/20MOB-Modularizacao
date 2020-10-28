package br.com.heiderlopes.data.repository

import br.com.heiderlopes.data.local.datasource.ProductCacheDataSource
import br.com.heiderlopes.data.remote.datasource.ProductRemoteDataSource
import br.com.heiderlopes.domain.entity.Product
import br.com.heiderlopes.domain.repository.ProductRepository
import io.reactivex.Single

class ProductRepositoryImpl (
    private val productsCacheDataSource: ProductCacheDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource
): ProductRepository {

    override fun getProducts(forceUpdate: Boolean): Single<List<Product>> {
        return if (forceUpdate)
            getProductsRemote(forceUpdate)
        else
            productsCacheDataSource.getProducts()
                .flatMap { products ->
                    when {
                        products.isEmpty() -> getProductsRemote(false)
                        else -> Single.just(products)
                    }
                }
    }

    private fun getProductsRemote(isUpdate: Boolean): Single<List<Product>> {
        return productRemoteDataSource.getProducts()
            .flatMap { products ->
                if (isUpdate)
                    productsCacheDataSource.updateData(products)
                else
                    productsCacheDataSource.insertData(products)
                Single.just(products)
            }
    }
}
