package com.example.nepekariproject.converters.cake.cakeUiAndBusinessConverter

import com.example.nepekariproject.converters.cakePart.cakePartUiAndBusinessConverter.CakePartUiAndBusinessConverter
import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.cake.CakeBusinessDtoImpl
import com.example.nepekariproject.dto.cake.CakeUIDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CakeUiAndBusinessConverterImpl: CakeUiAndBusinessConverter {
    @Autowired
    private lateinit var partConverter: CakePartUiAndBusinessConverter

    override fun convert(businessDto: CakeBusinessDto) = CakeUIDto(
        base = partConverter.convert(businessDto.getBase()),
        filling = partConverter.convert(businessDto.getFilling()),
        cream = partConverter.convert(businessDto.getCream())
    )

    override fun convert(uiDto: CakeUIDto) = CakeBusinessDtoImpl(
        base = partConverter.convert(uiDto.base),
        filling = partConverter.convert(uiDto.filling),
        cream = partConverter.convert(uiDto.cream)
    )

}