package com.example.nepekariproject.dao

import com.example.nepekariproject.dao.cake.CakeDao
import com.example.nepekariproject.exception.DataBaseException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CakeOrderDaoTest: AbstractTestcontainersTest() {
    @Autowired
    private lateinit var cakeDao: CakeDao

    @Test
    fun getCakeBaseParts() {
        val res = cakeDao.getCakeBaseParts()

        assertEquals(2, res.size)
        assertEquals("AwesomeBasePart1", res.find { it.getName() == "Base1" }?.getDescription()?.getTitle())
        assertEquals("AwesomeBasePart2", res.find { it.getName() == "Base2" }?.getDescription()?.getTitle())
    }

    @Test
    fun getCakeFillingParts() {
        val res = cakeDao.getCakeFillingParts()

        assertEquals(2, res.size)
        assertEquals("AwesomeFillingPart1", res.find { it.getName() == "Filling1" }?.getDescription()?.getTitle())
        assertEquals("AwesomeFillingPart2", res.find { it.getName() == "Filling2" }?.getDescription()?.getTitle())
    }

    @Test
    fun getCakeCreamParts() {
        val res = cakeDao.getCakeCreamParts()

        assertEquals(2, res.size)
        assertEquals("AwesomeCreamPart1", res.find { it.getName() == "Cream1" }?.getDescription()?.getTitle())
        assertEquals("AwesomeCreamPart2", res.find { it.getName() == "Cream2" }?.getDescription()?.getTitle())
    }

    @Test
    fun getCakeByPartIds() {
        val cake = cakeDao.getCakeByPartIds(2, 3, 6)

        assertEquals("Base2", cake.getBase().getName())
        assertEquals("Filling1", cake.getFilling().getName())
        assertEquals("Cream2", cake.getCream().getName())
    }

    @Test
    fun getCakeByPartIdsNegative() {
        assertThrows(DataBaseException::class.java) { cakeDao.getCakeByPartIds(1,1,1) }
    }

    @Test
    fun getCakePartById() {
        assertEquals("Base2", cakeDao.getCakePartById(2).getName())
        assertEquals("Filling1", cakeDao.getCakePartById(3).getName())
    }

    @Test
    fun getAllCakes() {
        val cakesList = cakeDao.getAllCakes()

        assertEquals(3, cakesList.size)
        assertEquals(3, cakesList.find {
            it.getBase().getId() == 2L && it.getFilling().getId() == 3L && it.getCream().getId() == 6L
        }?.getId())
    }
}