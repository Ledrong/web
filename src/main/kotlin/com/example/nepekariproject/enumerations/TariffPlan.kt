package com.example.nepekariproject.enumerations

enum class TariffPlan(val code: Int, val planName: String) {
    DEFAULT(1, "Массовый");

    companion object {
        fun findTariffPlanByCode(code: Int) = values().find { it.code == code } ?: DEFAULT
    }
}