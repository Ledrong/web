package com.example.nepekariproject.converters.product.productUiAndBusinessConverter

import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.dto.product.ProductUIDto

interface ProductUiAndBusinessConverter {
    fun convert(businessDto: ProductBusinessDto): ProductUIDto

    fun convert(uiDto: ProductUIDto): ProductBusinessDto
}