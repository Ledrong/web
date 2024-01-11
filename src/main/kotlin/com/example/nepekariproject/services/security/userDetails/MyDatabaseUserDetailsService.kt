package com.example.nepekariproject.services.security.userDetails

import com.example.nepekariproject.services.user.UserService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class MyDatabaseUserDetailsService: UserDetailsService {
    @Autowired
    private lateinit var userService: UserService

    private val logger = LogManager.getLogger(this::class.java)

    override fun loadUserByUsername(username: String?): UserDetails {
        val userDto = userService.getUser(username ?: "")
        if (userDto == null) {
            logger.error("Cant get user with username=$username")
            throw UsernameNotFoundException(username)
        }

        return User(
            userDto.getLogin(),
            userDto.getPassword(),
            userDto.getRoles().map { SimpleGrantedAuthority(it.role) }
        )
    }

}