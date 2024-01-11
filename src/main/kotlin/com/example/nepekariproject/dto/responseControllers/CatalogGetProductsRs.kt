package com.example.nepekariproject.dto.responseControllers

import com.example.nepekariproject.dto.product.ProductUIDto
import com.fasterxml.jackson.annotation.JsonProperty

class CatalogGetProductsRs(
    @JsonProperty
    val maxItemsPerPage: Int,
    @JsonProperty
    val catalog: List<ProductUIDto>
)