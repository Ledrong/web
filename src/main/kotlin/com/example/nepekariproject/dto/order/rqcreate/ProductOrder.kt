package com.example.nepekariproject.dto.order.rqcreate

import com.fasterxml.jackson.annotation.JsonProperty

class ProductOrder(
    @JsonProperty("id")
    val id: Int
)