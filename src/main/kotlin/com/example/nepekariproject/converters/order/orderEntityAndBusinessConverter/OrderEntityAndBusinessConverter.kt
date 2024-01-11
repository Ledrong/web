package com.example.nepekariproject.converters.order.orderEntityAndBusinessConverter

import com.example.nepekariproject.dto.order.OrderBusinessDto
import com.example.nepekariproject.entity.order.OrderEntity

interface OrderEntityAndBusinessConverter {
    fun convert(dto: OrderBusinessDto): OrderEntity

    fun convert(dto: OrderEntity): OrderBusinessDto
}