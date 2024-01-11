package com.example.nepekariproject.converters.bonus.bonusUiAndBusinessConverter

import com.example.nepekariproject.dto.bonus.BonusBusinessDto
import com.example.nepekariproject.dto.bonus.BonusBusinessDtoImpl
import com.example.nepekariproject.dto.bonus.BonusUIDto
import org.springframework.stereotype.Component

@Component
class BonusUiAndBusinessConverterImpl: BonusUiAndBusinessConverter {
    override fun convert(businessDto: BonusBusinessDto) = BonusUIDto(
        value = businessDto.getValue(),
        percentFlag = businessDto.getPercentFlag(),
        startDate = businessDto.getStartDate(),
        endDate = businessDto.getEndDate()
    )
}