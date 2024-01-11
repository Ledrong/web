package com.example.nepekariproject.dto.product

import com.example.nepekariproject.dto.bonus.BonusBusinessDto
import com.example.nepekariproject.dto.description.DescriptionBusinessDto

interface ProductBusinessDto {
    fun getId(): Long
    fun getName(): String
    fun getCost(): Double
    fun getImgUrl(): String
    fun getDescr(): DescriptionBusinessDto
    fun getBonuses(): List<BonusBusinessDto>?
}