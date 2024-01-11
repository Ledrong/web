package com.example.nepekariproject.converters.cakePart.cakePartUiAndBusinessConverter

import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import com.example.nepekariproject.dto.cakePart.CakePartUIDto

interface CakePartUiAndBusinessConverter {
    fun convert(businessDto: CakePartBusinessDto): CakePartUIDto

    fun convert(uiDto: CakePartUIDto): CakePartBusinessDto
}