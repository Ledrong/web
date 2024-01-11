package com.example.nepekariproject.dao.product

import com.example.nepekariproject.dto.product.ProductBusinessDto

interface ProductDao {
    fun getProductById(id: Long): ProductBusinessDto

    fun getProductsCatalog(): List<ProductBusinessDto>

    fun addProduct(product: ProductBusinessDto)

    fun deleteProduct(id: Long)
}