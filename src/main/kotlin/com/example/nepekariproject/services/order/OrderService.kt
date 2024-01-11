package com.example.nepekariproject.services.order

import com.example.nepekariproject.dto.order.OrderBusinessDto
import com.example.nepekariproject.dto.user.UserBusinessDto

interface OrderService {
    fun createOrder(order: OrderBusinessDto)

    fun getOrder(id: String): OrderBusinessDto?
    fun getUserOrders(user: UserBusinessDto, page: Int): List<OrderBusinessDto>
}