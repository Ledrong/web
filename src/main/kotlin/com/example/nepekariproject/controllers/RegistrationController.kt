package com.example.nepekariproject.controllers

import com.example.nepekariproject.config.DataSourceContextHolder
import com.example.nepekariproject.config.DataSourceEnum
import com.example.nepekariproject.converters.user.userUiAndBusinessConverter.UserUiAndBusinessConverter
import com.example.nepekariproject.dto.responseControllers.RegistrationPageRq
import com.example.nepekariproject.enumerations.Roles
import com.example.nepekariproject.exception.UnavailableTechnicalException
import com.example.nepekariproject.services.user.UserService
import com.example.nepekariproject.services.validation.account.AccountValidationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
@RequestMapping("/register")
class RegistrationController {
    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var userConverter: UserUiAndBusinessConverter

    @Autowired
    private lateinit var userAccountValidator: AccountValidationService

    @Autowired
    private lateinit var dataSourceContextHolder: DataSourceContextHolder

    @Resource
    private lateinit var env: Environment

    @CrossOrigin
    @PostMapping
    fun registerNewUser(@RequestBody newUserDto: RegistrationPageRq) {
        if (env.getRequiredProperty("connection.role") == "admin") {
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
            println("Set admin as dataSource")
        }
        else {
            println("Set auth as dataSource")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)
        }

        val businessDto = userConverter.convert(newUserDto, Roles.USER)

        userAccountValidator.validate(businessDto).takeIf { it.isNotEmpty() }?.let {
            throw UnavailableTechnicalException("Validation errors!")
        }

        userService.registerUser(businessDto).also {
            dataSourceContextHolder.clearContext()
        }
    }
}