package com.example.nepekariproject.repository

import com.example.nepekariproject.entity.cake_part.CakePartEntity
import com.example.nepekariproject.entity.custom_cake.CakeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface CakeRepository: JpaRepository<CakeEntity, Long> {

    @Query("SELECT p FROM CakePartEntity p WHERE p.id = ?1")
    fun getCakePartById(id: Long): CakePartEntity

    @Query("SELECT c FROM CakeEntity c WHERE c.basePart.id = ?1 and c.fillingPart.id = ?2 and c.creamPart = ?3")
    fun getCakeByPartByIds(idBase: Long, idFilling: Long, idCream: Long): CakePartEntity

    @Query("FROM CakeEntity")
    fun getAllCakes(): List<CakeEntity>

    @Query("SELECT c FROM CakeEntity c WHERE c.id = ?1")
    fun getCakeById(id: Long): CakeEntity
}