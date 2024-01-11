package com.example.nepekariproject.converters.description.descriptionUiAndBusinessConverter

import com.example.nepekariproject.dto.description.DescriptionBusinessDto
import com.example.nepekariproject.dto.description.DescriptionBusinessDtoImpl
import com.example.nepekariproject.dto.description.DescriptionUIDto
import org.springframework.stereotype.Component

@Component
class DescriptionUiAndBusinessConverterImpl: DescriptionUiAndBusinessConverter {
    override fun convert(businessDto: DescriptionBusinessDto) = DescriptionUIDto(
        title = businessDto.getTitle(),
        description = businessDto.getDescription(),
        urlImg = businessDto.getUrlImg(),
        amountCarb = businessDto.getAmountCarb(),
        amountPrt = businessDto.getAmountPrt(),
        amountFat = businessDto.getAmountFat(),
        expiryTimeDays = businessDto.getExpiryTimeDays()
    )
}