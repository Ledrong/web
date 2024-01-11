package com.example.nepekariproject.dto.bonus

import java.util.Date

interface BonusBusinessDto {
    fun getId(): Long
    fun getValue(): Double
    fun getPercentFlag(): Boolean
    fun getStartDate(): Date
    fun getEndDate(): Date
}