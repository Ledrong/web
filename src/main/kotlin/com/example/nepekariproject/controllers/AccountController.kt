package com.example.nepekariproject.controllers

import com.example.nepekariproject.config.DataSourceContextHolder
import com.example.nepekariproject.config.DataSourceEnum
import com.example.nepekariproject.converters.user.userUiAndBusinessConverter.UserUiAndBusinessConverter
import com.example.nepekariproject.dto.responseControllers.ModifyAccountRq
import com.example.nepekariproject.dto.user.UserUIDto
import com.example.nepekariproject.exception.UnavailableTechnicalException
import com.example.nepekariproject.services.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
@RequestMapping("/account")
class AccountController {
    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var userConverter: UserUiAndBusinessConverter

    @Autowired
    private lateinit var dataSourceContextHolder: DataSourceContextHolder

    @Resource
    private lateinit var env: Environment

    @CrossOrigin
    @GetMapping
    fun getInfoAccountData(@AuthenticationPrincipal user: User): UserUIDto {
        if (env.getRequiredProperty("connection.role") == "admin")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
        else
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)

        val userDto = userService.getUser(user.username) ?: throw UnavailableTechnicalException("Cant get user")

        dataSourceContextHolder.clearContext()

        return userConverter.convert(userDto)
    }

    @CrossOrigin
    @PatchMapping
    fun changeInfoAccount(
        @RequestBody request: ModifyAccountRq,
        @AuthenticationPrincipal user: User
    ) {
        if (env.getRequiredProperty("connection.role") == "admin")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
        else
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)

        val userDto = userService.getUser(user.username) ?: throw UnavailableTechnicalException("Cant get user")

        userDto.setName(request.name)
            .setSurname(request.surname)
            .setLastName(request.lastname)
            .setEmail(request.email)
            .setAddress(request.address)

        userService.updateUser(userDto)

        dataSourceContextHolder.clearContext()
    }
}