package com.example.nepekariproject.dto.requestControllers

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDataElement(
    @JsonProperty("intId")
    val intId: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("cost")
    val cost: Double
)

data class CakesDataElement(
    @JsonProperty("baseId")
    val baseId: Int,
    @JsonProperty("fillingId")
    val fillingId: Int,
    @JsonProperty("creamId")
    val creamId: Int
)

data class RequestOrderDto(
    @JsonProperty("productData")
    val productData: List<ProductDataElement>,
    @JsonProperty("cakesData")
    val cakesData: List<CakesDataElement>
)
