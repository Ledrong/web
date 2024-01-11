package com.example.nepekariproject.dto.responseControllers

import com.example.nepekariproject.dto.address.AddressDto
import com.fasterxml.jackson.annotation.JsonProperty

class RegistrationPageRq(
    @JsonProperty
    val login: String = "",
    @JsonProperty
    val password: String = "",
    @JsonProperty
    val name: String = "",
    @JsonProperty
    val surname: String = "",
    @JsonProperty
    val lastname: String = "",
    @JsonProperty
    val address: AddressDto = AddressDto(),
    @JsonProperty
    val email: String = ""
)
