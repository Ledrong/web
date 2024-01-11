package com.example.nepekariproject.services.product

import com.example.nepekariproject.controllers.CatalogController
import com.example.nepekariproject.dao.cake.CakeDao
import com.example.nepekariproject.dao.product.ProductDao
import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.util.PageItemsConstant
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl: ProductService {
    @Autowired
    private lateinit var productDao: ProductDao

    @Autowired
    private lateinit var cakeDao: CakeDao

    private val logger = LogManager.getLogger(CatalogController::class.java)

    override fun getProductById(id: Long) = productDao.getProductById(id)
    override fun getCakeByPartIds(idBase: Long, idFilling: Long, idCream: Long) = cakeDao.getCakeByPartIds(
        idBase, idFilling, idCream
    )

    override fun getAllCakes() = cakeDao.getAllCakes()

    override fun getProductCatalog(): List<ProductBusinessDto> = productDao.getProductsCatalog()

    override fun getProductCatalog(page: Int): List<ProductBusinessDto> {
        return getProductCatalog().chunked(PageItemsConstant.amountItemsInProductPage)
            .takeIf { page <= it.size }?.get(page - 1) ?: listOf()
    }

    override fun getCakeBaseParts(): List<CakePartBusinessDto> = cakeDao.getCakeBaseParts()

    override fun getCakeFillingParts(): List<CakePartBusinessDto> = cakeDao.getCakeFillingParts()

    override fun getCakeCreamParts(): List<CakePartBusinessDto> = cakeDao.getCakeCreamParts()
    override fun getAllCakeParts(): List<CakePartBusinessDto> {
        val resList = mutableListOf<CakePartBusinessDto>()

        getCakeBaseParts().forEach {
            resList.add(it)
            logger.debug(it.getId())
        }
        getCakeFillingParts().forEach {
            resList.add(it)
            logger.debug(it.getId())
        }
        getCakeCreamParts().forEach {
            resList.add(it)
            logger.debug(it.getId())
        }

        return resList.apply {
            forEach { logger.debug(it.getId()) }
        }
    }

    override fun addProduct(product: ProductBusinessDto) {
        productDao.addProduct(product)
    }

    override fun deleteProduct(productId: Long) {
        productDao.deleteProduct(productId)
    }

    override fun addCakePart(cakePart: CakePartBusinessDto) {
        cakeDao.addCakePart(cakePart)
    }

    override fun deleteCakePart(cakePartId: Long) {
        cakeDao.deleteCakePart(cakePartId)
    }

    override fun addCake(cakeDto: CakeBusinessDto) {
        cakeDao.addCake(cakeDto)
    }

    override fun deleteCake(cakeId: Long) {
        cakeDao.deleteCake(cakeId)
    }
}