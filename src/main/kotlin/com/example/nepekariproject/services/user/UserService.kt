package com.example.nepekariproject.services.user

import com.example.nepekariproject.dto.user.UserBusinessDto

interface UserService {
    fun getUser(login: String): UserBusinessDto?

    fun getUser(id: Long): UserBusinessDto?

    fun updateUser(userBusinessDto: UserBusinessDto)

    fun registerUser(userBusinessDto: UserBusinessDto)
}