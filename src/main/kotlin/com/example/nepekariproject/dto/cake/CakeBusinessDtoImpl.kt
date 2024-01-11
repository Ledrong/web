package com.example.nepekariproject.dto.cake

import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import org.springframework.stereotype.Component

@Component
class CakeBusinessDtoImpl(
    private var id: Long = 0L,
    private var base: CakePartBusinessDto,
    private var filling: CakePartBusinessDto,
    private var cream: CakePartBusinessDto
): CakeBusinessDto {
    override fun getId() = id
    override fun getBase() = base
    override fun getCream() = cream
    override fun getFilling() = filling
}