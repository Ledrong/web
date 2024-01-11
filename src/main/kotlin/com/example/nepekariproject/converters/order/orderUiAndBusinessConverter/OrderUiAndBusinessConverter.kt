package com.example.nepekariproject.converters.order.orderUiAndBusinessConverter

import com.example.nepekariproject.dto.order.OrderBusinessDto
import com.example.nepekariproject.dto.order.OrderUIDto
import com.example.nepekariproject.dto.order.rqcreate.CreateOrderRqUiDto
import com.example.nepekariproject.dto.user.UserBusinessDto

interface OrderUiAndBusinessConverter {
    fun convert(uiDto: OrderUIDto, userDto: UserBusinessDto): OrderBusinessDto

    fun convert(uiDto: CreateOrderRqUiDto, userDto: UserBusinessDto): OrderBusinessDto

    fun convert(businessDto: OrderBusinessDto): OrderUIDto
}