package com.example.nepekariproject.dto.order.rqcreate

import com.fasterxml.jackson.annotation.JsonProperty

class CakeOrder(
    @JsonProperty("baseId")
    val baseId: Int,
    @JsonProperty("fillingId")
    val fillingId: Int,
    @JsonProperty("creamId")
    val creamId: Int
)