package com.example.nepekariproject.dto.description

interface DescriptionBusinessDto {
    fun getId(): Long
    fun getTitle(): String
    fun getDescription(): String
    fun getUrlImg(): String
    fun getAmountCarb(): Double
    fun getAmountPrt(): Double
    fun getAmountFat(): Double
    fun getExpiryTimeDays(): Int
}