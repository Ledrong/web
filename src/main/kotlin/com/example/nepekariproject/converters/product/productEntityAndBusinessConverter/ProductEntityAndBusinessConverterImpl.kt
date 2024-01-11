package com.example.nepekariproject.converters.product.productEntityAndBusinessConverter

import com.example.nepekariproject.converters.description.descriptionEntityAndBusinessConverter.DescriptionEntityAndBusinessConverter
import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.dto.product.ProductBusinessDtoImpl
import com.example.nepekariproject.entity.product.ProductEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductEntityAndBusinessConverterImpl: ProductEntityAndBusinessConverter {
    @Autowired
    private lateinit var converterDescription: DescriptionEntityAndBusinessConverter

    override fun convert(dto: ProductBusinessDto): ProductEntity {
        return ProductEntity(
            id = dto.getId(),
            addDescr = converterDescription.convert(dto.getDescr()),
            name = dto.getName(),
            cost = dto.getCost(),
            imgName = dto.getImgUrl()
        )
    }

    override fun convert(dto: ProductEntity): ProductBusinessDto {
        return ProductBusinessDtoImpl(
            id = dto.id,
            addDescr = converterDescription.convert(dto.addDescr),
            name = dto.name,
            cost = dto.cost,
            imageUrl = dto.imgName ?: ""
        )
    }

}