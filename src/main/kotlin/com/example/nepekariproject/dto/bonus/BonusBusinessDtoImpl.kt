package com.example.nepekariproject.dto.bonus

import java.util.Date

class BonusBusinessDtoImpl(
    private var id: Long = 0L,
    private var value: Double = 0.0,
    private var percentFlag: Boolean = false,
    private var startDate: Date = Date(),
    private var endDate: Date = Date()
): BonusBusinessDto {
    override fun getId() = id
    override fun getValue() = value
    override fun getPercentFlag() = percentFlag
    override fun getStartDate() = startDate
    override fun getEndDate() = endDate

    override fun equals(other: Any?): Boolean {
        val otherBonus = other as? BonusBusinessDto ?: return false
        return this.id == otherBonus.getId() &&
                this.value == otherBonus.getValue() &&
                this.percentFlag == otherBonus.getPercentFlag() &&
                this.startDate == otherBonus.getStartDate() &&
                this.endDate == otherBonus.getEndDate()
    }
}