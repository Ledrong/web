package com.example.nepekariproject.enumerations

enum class StatusRegistrationRs(val status: Int, val msg: String) {
    OK(200, "Success"),
    FAIL(-999, "Unknown error")
}