package com.example.nepekariproject.dto.cake

import com.example.nepekariproject.dto.cakePart.CakePartUIDto
import com.fasterxml.jackson.annotation.JsonProperty

data class CakeUIDto(
    @JsonProperty
    val base: CakePartUIDto,
    @JsonProperty
    val filling: CakePartUIDto,
    @JsonProperty
    val cream: CakePartUIDto
) {
    fun getTotalCost() = base.cost + filling.cost + cream.cost
}