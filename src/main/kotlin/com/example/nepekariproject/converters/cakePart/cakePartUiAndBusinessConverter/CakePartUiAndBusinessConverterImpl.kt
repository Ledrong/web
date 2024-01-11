package com.example.nepekariproject.converters.cakePart.cakePartUiAndBusinessConverter

import com.example.nepekariproject.converters.description.descriptionUiAndBusinessConverter.DescriptionUiAndBusinessConverter
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDtoImpl
import com.example.nepekariproject.dto.cakePart.CakePartUIDto
import com.example.nepekariproject.dto.description.DescriptionBusinessDtoImpl
import com.example.nepekariproject.enumerations.CakePartType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CakePartUiAndBusinessConverterImpl: CakePartUiAndBusinessConverter {
    @Autowired
    private lateinit var descriptionConverter: DescriptionUiAndBusinessConverter

    override fun convert(businessDto: CakePartBusinessDto) = CakePartUIDto(
        id = businessDto.getId(),
        name = businessDto.getName(),
        cost = businessDto.getCost(),
        type = businessDto.getType().type,
        description = descriptionConverter.convert(businessDto.getDescription())
    )

    override fun convert(uiDto: CakePartUIDto) = CakePartBusinessDtoImpl(
        id = uiDto.id,
        name = uiDto.name,
        cost = uiDto.cost,
        type = CakePartType.getTypeCakeByType(uiDto.type),
        description = DescriptionBusinessDtoImpl(9, "", "", "")
    )
}