package com.example.nepekariproject.exception.handler

import com.example.nepekariproject.exception.BaseException
import java.util.*

data class MessageExceptionHandler(
    val timestamp: Date,
    val message: String,
    val exceptionCode: String
) {
    constructor(ex: BaseException) : this(ex.timestamp, ex.metaData, ex.code)
}