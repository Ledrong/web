package com.example.nepekariproject.converters.bonus.bonusUiAndBusinessConverter

import com.example.nepekariproject.dto.bonus.BonusBusinessDto
import com.example.nepekariproject.dto.bonus.BonusUIDto

interface BonusUiAndBusinessConverter {
    fun convert(businessDto: BonusBusinessDto): BonusUIDto
}