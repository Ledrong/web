package com.example.nepekariproject.dao.cake

import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto

interface CakeDao {
    fun getCakeBaseParts(): List<CakePartBusinessDto>

    fun getCakeFillingParts(): List<CakePartBusinessDto>

    fun getCakeCreamParts(): List<CakePartBusinessDto>

    fun getCakePartById(id: Long): CakePartBusinessDto

    fun getCakeByPartIds(idBase: Long, idFilling: Long, idCream: Long): CakeBusinessDto

    fun getAllCakes(): List<CakeBusinessDto>

    fun addCakePart(dto: CakePartBusinessDto)

    fun deleteCakePart(id: Long)

    fun addCake(dto: CakeBusinessDto)

    fun deleteCake(id: Long)
}