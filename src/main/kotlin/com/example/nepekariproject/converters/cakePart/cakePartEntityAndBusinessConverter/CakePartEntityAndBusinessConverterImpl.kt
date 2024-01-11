package com.example.nepekariproject.converters.cakePart.cakePartEntityAndBusinessConverter

import com.example.nepekariproject.converters.description.descriptionEntityAndBusinessConverter.DescriptionEntityAndBusinessConverter
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDtoImpl
import com.example.nepekariproject.entity.cake_part.CakePartEntity
import com.example.nepekariproject.enumerations.CakePartType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CakePartEntityAndBusinessConverterImpl : CakePartEntityAndBusinessConverter {
    @Autowired
    private lateinit var addDescrConverter: DescriptionEntityAndBusinessConverter

    override fun convert(dto: CakePartBusinessDto): CakePartEntity {
        return CakePartEntity(
            id = dto.getId(),
            name = dto.getName(),
            cost = dto.getCost(),
            type = dto.getType().type,
            addDescr = addDescrConverter.convert(dto.getDescription())
        )
    }

    override fun convert(dto: CakePartEntity): CakePartBusinessDto {
        return CakePartBusinessDtoImpl(
            id = dto.id,
            name = dto.name,
            cost = dto.cost,
            type = CakePartType.getTypeCakeByType(dto.type),
            description = addDescrConverter.convert(dto.addDescr)
        )
    }
}