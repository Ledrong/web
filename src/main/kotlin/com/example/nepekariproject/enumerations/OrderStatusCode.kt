package com.example.nepekariproject.enumerations

enum class OrderStatusCode(
    val statusCode: Int,
    val statusName: String
) {
    UNKNOWN(0, "Неизвестен"),
    SENT(1, "Заказ отправлен"),
    PREPARE(2, "Заказ обрабатывается"),
    COOKING(3, "Заказ готовится");

    companion object {
        fun getStatusByCode(code: Int) = values().find { it.statusCode == code } ?: UNKNOWN
    }
}