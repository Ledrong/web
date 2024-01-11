package com.example.nepekariproject.dto.bonus

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

class BonusUIDto(
    @JsonProperty
    val value: Double,
    @JsonProperty
    val percentFlag: Boolean,
    @JsonProperty
    val startDate: Date,
    @JsonProperty
    val endDate: Date
)