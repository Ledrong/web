package com.example.nepekariproject.converters.user.userUiAndBusinessConverter

import com.example.nepekariproject.dto.responseControllers.RegistrationPageRq
import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.dto.user.UserUIDto
import com.example.nepekariproject.enumerations.Roles

interface UserUiAndBusinessConverter {
    fun convert(businessDto: UserBusinessDto): UserUIDto

    fun convert(uiDto: RegistrationPageRq, role: Roles): UserBusinessDto
}