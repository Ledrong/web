package com.example.nepekariproject.dto.order.rqcreate

import com.example.nepekariproject.dto.address.AddressDto
import com.fasterxml.jackson.annotation.JsonProperty

data class CreateOrderRqUiDto(
    @JsonProperty("addressToSend")
    val addressToSend: AddressDto,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("products")
    val products: List<ProductOrder>,
    @JsonProperty("cakes")
    val cakes: List<CakeOrder>
)
