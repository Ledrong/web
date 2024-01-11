package com.example.nepekariproject.dto.address

import com.fasterxml.jackson.annotation.JsonProperty

class AddressDto(
    @JsonProperty("street")
    val street: String = "",
    @JsonProperty("city")
    val city: String = "",
    @JsonProperty("zip")
    val zip: String = ""
)