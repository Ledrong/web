package com.example.nepekariproject.repository

import com.example.nepekariproject.entity.cake_part.CakePartEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface CakePartRepository: JpaRepository<CakePartEntity, Long> {
    @Query("SELECT p FROM CakePartEntity p WHERE p.id = ?1")
    fun getCakePartById(id: Long): CakePartEntity
}