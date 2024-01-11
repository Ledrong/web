package com.example.nepekariproject.converters.description.descriptionUiAndBusinessConverter

import com.example.nepekariproject.dto.description.DescriptionBusinessDto
import com.example.nepekariproject.dto.description.DescriptionUIDto

interface DescriptionUiAndBusinessConverter {
    fun convert(businessDto: DescriptionBusinessDto): DescriptionUIDto
}