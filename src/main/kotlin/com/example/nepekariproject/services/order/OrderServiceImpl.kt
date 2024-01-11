package com.example.nepekariproject.services.order

import com.example.nepekariproject.dao.order.OrderDao
import com.example.nepekariproject.dto.order.OrderBusinessDto
import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.util.PageItemsConstant
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrderServiceImpl: OrderService {
    @Autowired
    private lateinit var orderDao: OrderDao

    private val logger = LogManager.getLogger(this::class.java)

    override fun createOrder(order: OrderBusinessDto) {
        orderDao.createNewOrder(order)
    }

    override fun getOrder(id: String) =
        try { orderDao.getOrderById(id) }
        catch (ex: Exception) {
            logger.error("Get order by id=$id returns exception")
            null
        }

    override fun getUserOrders(user: UserBusinessDto, page: Int): List<OrderBusinessDto> {
        val orders = orderDao.getUserOrders(user.getId())
        return orders.chunked(PageItemsConstant.amountItemsInOrderPage).takeIf { page <= it.size }?.get(page - 1)
            ?: listOf()
    }
}