package com.example.nepekariproject.dto.responseControllers

import com.example.nepekariproject.enumerations.StatusCreateOrderRq
import com.fasterxml.jackson.annotation.JsonProperty

data class CreateOrderFormRs(
    @JsonProperty
    val msg: String,
    @JsonProperty
    val status: StatusCreateOrderRq
)
