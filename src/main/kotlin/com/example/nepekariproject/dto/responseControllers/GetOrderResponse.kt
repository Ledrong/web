package com.example.nepekariproject.dto.responseControllers

import com.example.nepekariproject.dto.order.OrderUIDto
import com.fasterxml.jackson.annotation.JsonProperty

class GetOrderResponse(
    @JsonProperty
    val maxItemsPerPage: Int,
    @JsonProperty
    val orders: List<OrderUIDto>
)