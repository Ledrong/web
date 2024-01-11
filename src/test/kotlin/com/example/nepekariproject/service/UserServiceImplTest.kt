package com.example.nepekariproject.service

import com.example.nepekariproject.dao.user.UserDao
import com.example.nepekariproject.dto.user.UserBusinessDtoImpl
import com.example.nepekariproject.exception.DataBaseException
import com.example.nepekariproject.services.user.UserServiceImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.springframework.security.crypto.password.PasswordEncoder
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserServiceImplTest {
    @InjectMockKs
    private lateinit var userService: UserServiceImpl

    @MockK
    private lateinit var userDao: UserDao

    @MockK
    private lateinit var passwordEncoder: PasswordEncoder

    @BeforeTest
    fun initMocks() {
        MockKAnnotations.init(this)
    }

    @Test
    fun negativeTestGetUser() {
        every { userDao.getUserByLogin(any()) } throws DataBaseException("abc")
        val res = userService.getUser("someLogin")
        assertTrue{ res == null }
    }

    @Test
    fun getUserByLogin() {
        every { userDao.getUserByLogin(any()) } returns UserBusinessDtoImpl(id = 1, login = "zenya")
        assertEquals(userService.getUser("zenya")?.getId(), 1)
    }

    @Test
    fun getUserById() {
        every { userDao.getUserById(any()) } returns UserBusinessDtoImpl(id = 1, login = "zenya")
        assertEquals(userService.getUser(1)?.getLogin(), "zenya")
    }

    @Test
    fun updateUser() {
        every { userDao.updateInfoAboutUser(any()) } returns Unit
        userService.updateUser(UserBusinessDtoImpl(id = 1, login = "zenya"))
    }

    @Test
    fun registerUser() {
        val user = UserBusinessDtoImpl(id = 1, login = "zenya", password = "qwerty123",
            name = "evgenii", surname = "konyaev")
        every { passwordEncoder.encode(any()) } returns "qwerty456"
        every { userDao.saveNewUser(any()) } returns Unit
        userService.registerUser(user)
        assertEquals(user.getPassword(), "qwerty456")
    }
}