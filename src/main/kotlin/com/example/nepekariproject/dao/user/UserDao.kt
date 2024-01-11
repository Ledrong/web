package com.example.nepekariproject.dao.user

import com.example.nepekariproject.dto.user.UserBusinessDto

interface UserDao {
    fun getUserByLogin(userLogin: String): UserBusinessDto
    fun getUserById(userId: Long): UserBusinessDto

    fun saveNewUser(user: UserBusinessDto)
    fun updateInfoAboutUser(user: UserBusinessDto)
}