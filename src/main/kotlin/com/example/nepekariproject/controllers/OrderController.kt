package com.example.nepekariproject.controllers

import com.example.nepekariproject.config.DataSourceContextHolder
import com.example.nepekariproject.config.DataSourceEnum
import com.example.nepekariproject.converters.order.orderUiAndBusinessConverter.OrderUiAndBusinessConverter
import com.example.nepekariproject.dto.order.rqcreate.CreateOrderRqUiDto
import com.example.nepekariproject.dto.responseControllers.GetOrderResponse
import com.example.nepekariproject.exception.UnavailableTechnicalException
import com.example.nepekariproject.services.order.OrderService
import com.example.nepekariproject.services.user.UserService
import com.example.nepekariproject.util.PageItemsConstant
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
@RequestMapping("/order")
@SessionAttributes("orderData")
class OrderController {
    @Autowired
    private lateinit var orderConverter: OrderUiAndBusinessConverter

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var orderService: OrderService

    @Autowired
    private lateinit var dataSourceContextHolder: DataSourceContextHolder

    @Resource
    private lateinit var env: Environment

    private val logger = LogManager.getLogger(OrderController::class.java)

    @CrossOrigin
    @GetMapping
    fun getUserOrders(
        @RequestParam("page") page: Int,
        @AuthenticationPrincipal user: User
    ): GetOrderResponse {
        takeIf { page <= 0 }?.let { throw UnavailableTechnicalException("Page must be not negative") }

        if (env.getRequiredProperty("connection.role") == "admin")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
        else
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)

        val userModel = userService.getUser(user.username) ?: throw UnavailableTechnicalException("Cant get user")

        return GetOrderResponse(
            PageItemsConstant.amountItemsInOrderPage,
            orderService.getUserOrders(userModel, page).map { orderConverter.convert(it) }
        ).also {
            dataSourceContextHolder.clearContext()
        }
    }

    @CrossOrigin
    @PostMapping
    fun createOrder(
        @RequestBody order: CreateOrderRqUiDto,
        @AuthenticationPrincipal user: User
    ) {
        if (env.getRequiredProperty("connection.role") == "admin")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
        else
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)

        val userModel = userService.getUser(user.username) ?: throw UnavailableTechnicalException("Cant get user")
        val orderModel = orderConverter.convert(order, userModel)
        orderService.createOrder(orderModel).also {
            dataSourceContextHolder.clearContext()
        }
    }
}