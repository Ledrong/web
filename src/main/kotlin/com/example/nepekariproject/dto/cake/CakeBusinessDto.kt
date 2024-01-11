package com.example.nepekariproject.dto.cake

import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto

interface CakeBusinessDto {
    fun getId(): Long
    fun getBase(): CakePartBusinessDto
    fun getCream(): CakePartBusinessDto
    fun getFilling(): CakePartBusinessDto
}