package com.example.nepekariproject.dto.order

import com.example.nepekariproject.dto.address.AddressDto
import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.enumerations.OrderStatusCode
import java.util.*

interface OrderBusinessDto {
    fun getOrderId(): String
    fun getUser(): UserBusinessDto
    fun getDateCreate(): Date
    fun getDateExpiry(): Date
    fun getAddressToSend(): AddressDto
    fun getDescription(): String
    fun getStatusCode(): OrderStatusCode
    fun getProducts(): List<ProductBusinessDto>
    fun getCakes(): List<CakeBusinessDto>
}