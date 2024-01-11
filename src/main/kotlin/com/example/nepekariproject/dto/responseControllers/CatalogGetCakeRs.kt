package com.example.nepekariproject.dto.responseControllers

import com.example.nepekariproject.dto.cakePart.CakePartUIDto
import com.fasterxml.jackson.annotation.JsonProperty

class CatalogGetCakeRs(
    @JsonProperty
    val cakesItems: List<CakePartUIDto> = listOf()
)