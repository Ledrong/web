package com.example.nepekariproject.services.product

import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import com.example.nepekariproject.dto.product.ProductBusinessDto

interface ProductService {
    fun getProductById(id: Long): ProductBusinessDto

    fun getCakeByPartIds(idBase: Long, idFilling: Long, idCream: Long): CakeBusinessDto

    fun getAllCakes(): List<CakeBusinessDto>

    fun getProductCatalog(): List<ProductBusinessDto>
    fun getProductCatalog(page: Int): List<ProductBusinessDto>
    fun getCakeBaseParts(): List<CakePartBusinessDto>
    fun getCakeFillingParts(): List<CakePartBusinessDto>
    fun getCakeCreamParts(): List<CakePartBusinessDto>
    fun getAllCakeParts(): List<CakePartBusinessDto>

    fun addProduct(product: ProductBusinessDto)
    fun deleteProduct(productId: Long)

    fun addCakePart(cakePart: CakePartBusinessDto)
    fun deleteCakePart(cakePartId: Long)

    fun addCake(cakeDto: CakeBusinessDto)
    fun deleteCake(cakeId: Long)
}