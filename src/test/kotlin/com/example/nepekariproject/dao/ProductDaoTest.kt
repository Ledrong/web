package com.example.nepekariproject.dao

import com.example.nepekariproject.dao.product.ProductDao
import com.example.nepekariproject.exception.DataBaseException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductDaoTest: AbstractTestcontainersTest() {
    @Autowired
    private lateinit var productDao: ProductDao

    @Test
    fun getProductById() {
        val res = productDao.getProductById(1)

        assertEquals(res.getName(), "Bread")
        assertEquals(res.getCost(), 15.99)
        assertEquals(res.getDescr().getTitle(), "Awesome Bread")
        assertEquals(res.getDescr().getAmountCarb(), 5.0)
    }

    @Test
    fun getProductByIdNegative() {
        assertThrows(DataBaseException::class.java) { productDao.getProductById(505) }
    }

    @Test
    fun getProductCatalog() {
        val res = productDao.getProductsCatalog()


        assertEquals(res.find { it.getName() == "Baget" }?.getCost(), 19.99)
        assertEquals(res.find { it.getName() == "Bread" }?.getCost(), 15.99)

        assertEquals(res.find { it.getName() == "Baget" }?.getDescr()?.getTitle(), "Awesome Baget")
        assertEquals(res.find { it.getName() == "Baget" }?.getDescr()?.getAmountCarb(), 5.0)

        assertEquals(res.find { it.getName() == "Bread" }?.getDescr()?.getTitle(), "Awesome Bread")
        assertEquals(res.find { it.getName() == "Bread" }?.getDescr()?.getAmountCarb(), 5.0)
    }
}