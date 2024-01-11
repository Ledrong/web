package com.example.nepekariproject.dto.order

import com.example.nepekariproject.dto.address.AddressDto
import com.example.nepekariproject.dto.cake.CakeUIDto
import com.example.nepekariproject.dto.product.ProductUIDto
import com.example.nepekariproject.enumerations.OrderStatusCode
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class OrderUIDto(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("dateCreate")
    val dateCreate: Date = Date(),
    @JsonProperty("dateExpiry")
    val dateExpiry: Date = Date(),
    @JsonProperty("addressToSend")
    val addressToSend: AddressDto = AddressDto(),
    @JsonProperty("description")
    val description: String = "",
    @JsonProperty("statusCode")
    val statusCode: OrderStatusCode = OrderStatusCode.UNKNOWN,
    @JsonProperty("products")
    val products: List<ProductUIDto> = listOf(),
    @JsonProperty("cakes")
    val cakes: List<CakeUIDto> = listOf()
)
