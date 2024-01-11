package com.example.nepekariproject.dto.description

import org.springframework.stereotype.Component

@Component
class DescriptionBusinessDtoImpl(
    private var id: Long = 0,
    private var title: String = "",
    private var description: String = "",
    private var urlImg: String = "",
    private var amountCarb: Double = 0.0,
    private var amountPrt: Double = 0.0,
    private var amountFat: Double = 0.0,
    private var expiryTimeDays: Int = 0
): DescriptionBusinessDto {
    override fun getId() = id
    override fun getTitle() = title
    override fun getDescription() = description
    override fun getUrlImg() = urlImg
    override fun getAmountCarb() = amountCarb
    override fun getAmountPrt() = amountPrt
    override fun getAmountFat() = amountFat
    override fun getExpiryTimeDays() = expiryTimeDays
}