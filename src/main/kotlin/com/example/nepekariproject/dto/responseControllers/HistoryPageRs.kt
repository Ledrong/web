package com.example.nepekariproject.dto.responseControllers

import com.example.nepekariproject.dto.order.OrderUIDto
import com.fasterxml.jackson.annotation.JsonProperty

data class HistoryPageRs(
    @JsonProperty
    val orders: List<OrderUIDto>?
)