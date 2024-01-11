package com.example.nepekariproject.dao.order

import com.example.nepekariproject.dto.order.OrderBusinessDto

interface OrderDao {
    fun getOrderById(orderId: String): OrderBusinessDto
    fun getUserOrders(userId: Long): List<OrderBusinessDto>

    fun createNewOrder(order: OrderBusinessDto)
}