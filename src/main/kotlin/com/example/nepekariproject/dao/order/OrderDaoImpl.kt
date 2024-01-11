package com.example.nepekariproject.dao.order

import com.example.nepekariproject.converters.order.orderEntityAndBusinessConverter.OrderEntityAndBusinessConverter
import com.example.nepekariproject.dto.order.OrderBusinessDto
import com.example.nepekariproject.entity.order.OrderEntity
import com.example.nepekariproject.exception.DataBaseException
import com.example.nepekariproject.exception.UnavailableTechnicalException
import com.example.nepekariproject.repository.OrderRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
class OrderDaoImpl: OrderDao {
    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Autowired
    private lateinit var orderConverter: OrderEntityAndBusinessConverter

    private val logger = LogManager.getLogger(this::class.java)

    override fun getOrderById(orderId: String): OrderBusinessDto {
        val order: OrderEntity
        try {
            order = orderRepository.getOrderById(orderId)
        } catch (ex: EmptyResultDataAccessException) {
            logger.error("Cant find order by id=$orderId")
            throw DataBaseException("Cant find order by id=$orderId")
        } catch (ex: DataAccessException) {
            logger.error("getOrderById (id = $orderId) fails.\n${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }

        return orderConverter.convert(order)
    }

    override fun getUserOrders(userId: Long): List<OrderBusinessDto> {
        val orders: List<OrderEntity>
        try {
            orders = orderRepository.getUserOrders(userId)
        } catch (ex: DataAccessException) {
            logger.error("getUserOrders (id = $userId) fails.\n${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }

        return orders.map { orderConverter.convert(it) }
    }

    override fun createNewOrder(order: OrderBusinessDto) {
        val orderEntity: OrderEntity

        try {
            orderEntity = orderConverter.convert(order)
        } catch (ex: Exception) {
            logger.error("orderConverter.convert(OrderBusinessDto) fails.\n${ex.message}\n${ex.cause}")
            throw UnavailableTechnicalException(ex.stackTraceToString())
        }

        orderRepository.save(orderEntity)
    }
}