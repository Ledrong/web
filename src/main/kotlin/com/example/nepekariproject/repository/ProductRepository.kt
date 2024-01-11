package com.example.nepekariproject.repository

import com.example.nepekariproject.entity.product.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Transactional
@Repository
interface ProductRepository: JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.id = ?1")
    fun getProductById(id: Long): ProductEntity

    @Query("FROM ProductEntity")
    fun getProductsCatalog(): List<ProductEntity>
}