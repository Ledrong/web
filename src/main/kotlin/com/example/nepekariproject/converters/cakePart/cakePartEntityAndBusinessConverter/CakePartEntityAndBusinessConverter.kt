package com.example.nepekariproject.converters.cakePart.cakePartEntityAndBusinessConverter

import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import com.example.nepekariproject.entity.cake_part.CakePartEntity

interface CakePartEntityAndBusinessConverter {
    fun convert(dto: CakePartBusinessDto): CakePartEntity

    fun convert(dto: CakePartEntity): CakePartBusinessDto
}