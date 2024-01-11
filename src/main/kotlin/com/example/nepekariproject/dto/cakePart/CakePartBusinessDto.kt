package com.example.nepekariproject.dto.cakePart

import com.example.nepekariproject.dto.description.DescriptionBusinessDto
import com.example.nepekariproject.enumerations.CakePartType

interface CakePartBusinessDto {
    fun getId(): Long
    fun getName(): String
    fun getCost(): Double
    fun getType(): CakePartType
    fun getDescription(): DescriptionBusinessDto
}