package com.example.nepekariproject.converters.product.productEntityAndBusinessConverter

import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.entity.product.ProductEntity

interface ProductEntityAndBusinessConverter {
    fun convert(dto: ProductBusinessDto): ProductEntity

    fun convert(dto: ProductEntity): ProductBusinessDto
}