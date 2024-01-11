package com.example.nepekariproject.dao

import com.example.nepekariproject.dao.order.OrderDao
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderDaoTest: AbstractTestcontainersTest() {
    @Autowired
    private lateinit var orderDao: OrderDao

    @Test
    fun getOrderById() {
        val order = orderDao.getOrderById("abc1")

        assertEquals("zenya", order.getUser().getLogin())
        assertEquals(0, order.getCakes().size)
        assertEquals(3, order.getProducts().size)
        assertEquals(2, order.getProducts().filter { it.getId() == 1L }.size)
    }

    @Test
    fun getUserOrders() {
        val orders = orderDao.getUserOrders(1)

        assertEquals(2, orders.size)
        assertEquals(0, orders.find { it.getOrderId() == "abc1" }?.getCakes()?.size)
        assertEquals(2, orders.find { it.getOrderId() == "abc2" }?.getCakes()?.size)
        assertEquals("Base1", orders.find { it.getOrderId() == "abc2" }?.getCakes()?.find {
            it.getId() == 2L
        }?.getBase()?.getName())
    }
}