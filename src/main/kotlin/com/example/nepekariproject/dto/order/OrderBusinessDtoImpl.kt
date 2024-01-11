package com.example.nepekariproject.dto.order

import com.example.nepekariproject.dto.address.AddressDto
import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.enumerations.OrderStatusCode
import org.springframework.stereotype.Component
import java.util.Date

@Component
class OrderBusinessDtoImpl(
    private var orderId: String = "",
    private var dateCreate: Date = Date(),
    private var dateExpiry: Date = Date(),
    private var addressToSend: AddressDto = AddressDto(),
    private var description: String = "",
    private var statusCode: OrderStatusCode = OrderStatusCode.PREPARE,
    private var user: UserBusinessDto,
    private var products: List<ProductBusinessDto>,
    private var cakes: List<CakeBusinessDto>
): OrderBusinessDto {
    override fun getOrderId() = orderId
    override fun getUser() = user
    override fun getDateCreate() = dateCreate
    override fun getDateExpiry() = dateExpiry
    override fun getAddressToSend() = addressToSend
    override fun getDescription() = description
    override fun getStatusCode() = statusCode
    override fun getProducts() = products
    override fun getCakes() = cakes
}