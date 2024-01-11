package com.example.nepekariproject.dto.responseControllers

import com.example.nepekariproject.dto.user.UserUIDto
import com.fasterxml.jackson.annotation.JsonProperty

data class GetAccountRs(
    @JsonProperty
    val user: UserUIDto,
)