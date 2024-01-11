package com.example.nepekariproject.enumerations

enum class CakePartType(val type: Int) {
    UNKNOWN(0),
    BASE(1),
    FILLING(2),
    CREAM(3);

    companion object {
        fun getTypeCakeByType(type: Int) = values().find { it.type == type } ?: UNKNOWN
    }
}
