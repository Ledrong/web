package com.example.nepekariproject.dto.description

import com.fasterxml.jackson.annotation.JsonProperty

class DescriptionUIDto(
    @JsonProperty
    val title: String,
    @JsonProperty
    val description: String,
    @JsonProperty
    val urlImg: String,
    @JsonProperty
    val amountCarb: Double,
    @JsonProperty
    val amountPrt: Double,
    @JsonProperty
    val amountFat: Double,
    @JsonProperty
    val expiryTimeDays: Int
)