package com.example.nepekariproject.dto.user

import com.example.nepekariproject.dto.address.AddressDto
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class UserUIDto(
    @JsonProperty
    val id: Long = 0L,
    @JsonProperty
    val name: String = "",
    @JsonProperty
    val surname: String = "",
    @JsonProperty
    val lastname: String = "",
    @JsonProperty
    val address: AddressDto = AddressDto(),
    @JsonProperty
    val regDate: Date = Date(),
    @JsonProperty
    val email: String = ""
)