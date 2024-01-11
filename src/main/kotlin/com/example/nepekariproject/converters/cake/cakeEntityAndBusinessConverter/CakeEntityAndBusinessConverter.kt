package com.example.nepekariproject.converters.cake.cakeEntityAndBusinessConverter

import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.entity.custom_cake.CakeEntity

interface CakeEntityAndBusinessConverter {
    fun convert(dto: CakeEntity): CakeBusinessDto

    fun convert(dto: CakeBusinessDto): CakeEntity
}