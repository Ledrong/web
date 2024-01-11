package com.example.nepekariproject.dao

import com.example.nepekariproject.dao.user.UserDao
import com.example.nepekariproject.dto.user.UserBusinessDtoImpl
import com.example.nepekariproject.exception.DataBaseException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserDaoTest : AbstractTestcontainersTest() {

    @Autowired
    private lateinit var userDao: UserDao

    @Test
    fun findByLogin() {
        assertEquals(userDao.getUserByLogin("zenya").getLogin(), "zenya")
    }

    @Test
    fun findByLoginNegative() {
        assertThrows(DataBaseException::class.java) { userDao.getUserByLogin("zenyaa") }
    }

    @Test
    fun findById() {
        assertEquals(userDao.getUserById(1).getLogin(), "zenya")
    }

    @Test
    fun findByIdNegative() {
        assertThrows(DataBaseException::class.java) { userDao.getUserById(1243325).getLogin() }
    }

    @Test
    fun saveNewUser() {
        userDao.saveNewUser(UserBusinessDtoImpl(
            login = "abrikos",
            password = "qwerty"
        ))

        assertEquals(userDao.getUserByLogin("abrikos").getLogin(), "abrikos")
        assertEquals(userDao.getUserByLogin("abrikos").getId(), 2)
    }

    @Test
    fun updateUser() {
        userDao.updateInfoAboutUser(UserBusinessDtoImpl(
            id = 1,
            login = "zenya",
            password = "qwerty123"
        ))

        assertEquals(userDao.getUserByLogin("zenya").getPassword(), "qwerty123")
    }
}
