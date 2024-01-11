package com.example.nepekariproject.validation

import com.example.nepekariproject.dto.user.UserBusinessDtoImpl
import com.example.nepekariproject.services.user.UserService
import com.example.nepekariproject.services.validation.account.AccountValidationServiceImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.testng.annotations.BeforeTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AccountValidationServiceImplTest {
    @InjectMockKs
    private lateinit var accountValidationService: AccountValidationServiceImpl

    @MockK
    private lateinit var userService: UserService

    @BeforeTest
    fun initMock() {
        MockKAnnotations.init(this)
    }

    @Test
    fun positiveValidationTest() {
        every { userService.getUser("superlogin123") } returns null
        val dto = UserBusinessDtoImpl().apply {
            setLogin("superlogin123")
            setPassword("superPassword123")
        }

        val results = accountValidationService.validate(dto)
        assertTrue{  results.isEmpty() }
    }

    @DataProvider
    fun dataNegativeValidation() = arrayOf(
        arrayOf("", "1244353"),
        arrayOf("213", "1224512"),
        arrayOf("1".repeat(40), "dsfdfwesaafg")
    )

    @Test(dataProvider = "dataNegativeValidation")
    fun negativeValidationTest(login: String, password: String) {
        every { userService.getUser(login) } returns null
        val dto = UserBusinessDtoImpl().apply {
            setLogin(login)
            setPassword(password)
        }

        val results = accountValidationService.validate(dto)

        assertFalse{  results.isEmpty() }
    }
}