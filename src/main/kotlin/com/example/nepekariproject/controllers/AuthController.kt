package com.example.nepekariproject.controllers

import com.example.nepekariproject.config.DataSourceContextHolder
import com.example.nepekariproject.config.DataSourceEnum
import com.example.nepekariproject.services.user.UserService
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.Resource

@RestController
@RequestMapping("/auth")
class AuthController {
    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var dataSourceContextHolder: DataSourceContextHolder

    @Resource
    private lateinit var env: Environment

    data class LoginUserParam(
        @JsonProperty("username")
        val username: String,
        @JsonProperty("password")
        val password: String
    ) {
        constructor(): this("", "")
    }

    data class LoginUserRs(
        val token: String
    ) {
        constructor(): this("")
    }

    @CrossOrigin
    @PostMapping("/login")
    fun loginUser(
        @RequestBody param: LoginUserParam
    ): ResponseEntity<LoginUserRs?> {
        if (env.getRequiredProperty("connection.role") == "admin")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
        else
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)

        userService.getUser(param.username) ?:
            return ResponseEntity<LoginUserRs?>(null, HttpHeaders(), HttpStatus.NOT_FOUND)

        val strToEncode = "${param.username}:${param.password}"
        val encodeValue = "Basic ${Base64.getEncoder().encodeToString(strToEncode.toByteArray())}"
        println("gived encodedvalue: $encodeValue")

        dataSourceContextHolder.clearContext()

        return ResponseEntity<LoginUserRs?>(LoginUserRs(encodeValue), HttpHeaders(), HttpStatus.OK)
    }
}