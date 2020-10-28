package br.com.heiderlopes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductCache(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String = "",
    val imageURL: String = "",
    val description: String = ""
)