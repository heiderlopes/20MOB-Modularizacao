package br.com.heiderlopes.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductPayload (
    @SerializedName("nome") val name: String,
    @SerializedName("urlImagem")val imageURL: String,
    @SerializedName("descricao")val description: String
)
