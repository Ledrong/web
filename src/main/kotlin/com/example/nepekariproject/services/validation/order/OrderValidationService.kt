package com.example.nepekariproject.services.validation.order

import com.example.nepekariproject.dto.order.OrderBusinessDto

interface OrderValidationService {
    fun isCorrectOrder(order: OrderBusinessDto): Boolean
}