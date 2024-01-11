package com.example.nepekariproject.converters.description.descriptionEntityAndBusinessConverter

import com.example.nepekariproject.dto.description.DescriptionBusinessDto
import com.example.nepekariproject.entity.add_descr.DescrEntity

interface DescriptionEntityAndBusinessConverter {
    fun convert(dto: DescriptionBusinessDto): DescrEntity

    fun convert(dto: DescrEntity): DescriptionBusinessDto
}