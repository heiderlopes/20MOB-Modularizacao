package br.com.heiderlopes.data.remote.mapper

import br.com.heiderlopes.data.remote.model.ProductPayload
import br.com.heiderlopes.domain.entity.Product

object ProductPayloadMapper {

    fun map(products: List<ProductPayload>) = products.map { map(it) }

    private fun map(productPayload: ProductPayload) = Product(
        name = productPayload.name,
        imageURL = productPayload.imageURL,
        description = productPayload.description
    )
}
