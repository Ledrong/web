package com.example.nepekariproject.converters.cake.cakeUiAndBusinessConverter

import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.cake.CakeUIDto

interface CakeUiAndBusinessConverter {
    fun convert(businessDto: CakeBusinessDto): CakeUIDto

    fun convert(uiDto: CakeUIDto): CakeBusinessDto
}