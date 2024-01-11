package com.example.nepekariproject.repository

import com.example.nepekariproject.entity.order.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface OrderRepository: JpaRepository<OrderEntity, Long> {
    @Query("SELECT o FROM OrderEntity o WHERE o.user.id =  ?1")
    fun getUserOrders(userId: Long): List<OrderEntity>

    @Query("SELECT o FROM OrderEntity o WHERE o.id =  ?1")
    fun getOrderById(orderId: String): OrderEntity
}