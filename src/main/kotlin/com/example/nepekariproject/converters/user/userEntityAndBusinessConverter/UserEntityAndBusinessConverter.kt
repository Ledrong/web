package com.example.nepekariproject.converters.user.userEntityAndBusinessConverter

import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.entity.user.UserEntity

interface UserEntityAndBusinessConverter {
    fun convert(dto: UserEntity): UserBusinessDto

    fun convert(dto: UserBusinessDto): UserEntity
}