package com.example.nepekariproject.converters.product.productUiAndBusinessConverter

import com.example.nepekariproject.converters.bonus.bonusUiAndBusinessConverter.BonusUiAndBusinessConverter
import com.example.nepekariproject.converters.description.descriptionUiAndBusinessConverter.DescriptionUiAndBusinessConverter
import com.example.nepekariproject.dto.description.DescriptionBusinessDtoImpl
import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.dto.product.ProductBusinessDtoImpl
import com.example.nepekariproject.dto.product.ProductUIDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductUiAndBusinessConverterImpl: ProductUiAndBusinessConverter {
    @Autowired
    private lateinit var descriptionConverter: DescriptionUiAndBusinessConverter

    @Autowired
    private lateinit var bonusConverter: BonusUiAndBusinessConverter

    override fun convert(businessDto: ProductBusinessDto) = ProductUIDto(
        id = businessDto.getId(),
        name = businessDto.getName(),
        cost = businessDto.getCost(),
        urlImg = businessDto.getImgUrl(),
        description = descriptionConverter.convert(businessDto.getDescr()),
        bonuses = businessDto.getBonuses()?.map { bonusConverter.convert(it) }
    )

    override fun convert(uiDto: ProductUIDto) = ProductBusinessDtoImpl(
        name = uiDto.name,
        cost = uiDto.cost,
        imageUrl = uiDto.urlImg,
        addDescr = DescriptionBusinessDtoImpl(1, "test_title", "test_description", "test_url_img")
    )
}