package com.example.nepekariproject.dao.product

import com.example.nepekariproject.converters.product.productEntityAndBusinessConverter.ProductEntityAndBusinessConverter
import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.entity.product.ProductEntity
import com.example.nepekariproject.exception.DataBaseException
import com.example.nepekariproject.exception.UnavailableTechnicalException
import com.example.nepekariproject.repository.ProductRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
class ProductDaoImpl: ProductDao {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var productConverter: ProductEntityAndBusinessConverter

    private val logger = LogManager.getLogger(this::class.java)


    override fun getProductById(id: Long): ProductBusinessDto {
        val productEntity: ProductEntity
        try {
            productEntity = productRepository.getProductById(id)
        } catch (ex: EmptyResultDataAccessException) {
            logger.error("Cant find product by id=$id")
            throw DataBaseException("Cant find product by id=$id")
        } catch (ex: DataAccessException) {
            logger.error("getProductById (id = $id) fails.\n${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }

        return productConverter.convert(productEntity)
    }

    override fun getProductsCatalog(): List<ProductBusinessDto> {
        val result: List<ProductEntity>

        try {
            result = productRepository.getProductsCatalog()
        } catch (ex: DataAccessException) {
            logger.error("getProductsCatalog fails.\n${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }

        return result.map { productConverter.convert(it) }
    }

    override fun addProduct(product: ProductBusinessDto) {
        val entity: ProductEntity

        try {
            entity = productConverter.convert(product)
        } catch (ex: Exception) {
            logger.error("cant convert product business dto to Entity.\n${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }

        logger.debug("Entity product before save: $entity")
        try {
            productRepository.save(entity)
        } catch (ex: DataAccessException) {
            logger.error("Cant save productEntity to database.\n${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }

    }

    override fun deleteProduct(id: Long) {
        logger.debug("deleting productCatalog with id=$id")
        try {
        productRepository.delete(productRepository.getProductById(id))
        } catch (ex: DataAccessException) {
            logger.error("Cant delete product with id=$id.\n ${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }
    }

}