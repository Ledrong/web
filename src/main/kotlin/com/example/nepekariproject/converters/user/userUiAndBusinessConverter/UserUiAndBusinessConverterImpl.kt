package com.example.nepekariproject.converters.user.userUiAndBusinessConverter

import com.example.nepekariproject.dto.responseControllers.RegistrationPageRq
import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.dto.user.UserBusinessDtoImpl
import com.example.nepekariproject.dto.user.UserUIDto
import com.example.nepekariproject.enumerations.Roles
import org.springframework.stereotype.Component

@Component
class UserUiAndBusinessConverterImpl: UserUiAndBusinessConverter {
    override fun convert(businessDto: UserBusinessDto) = UserUIDto(
        businessDto.getId(),
        businessDto.getName(),
        businessDto.getSurname(),
        businessDto.getLastName(),
        businessDto.getAddress(),
        businessDto.getRegDate(),
        businessDto.getEmail()
    )

    override fun convert(uiDto: RegistrationPageRq, role: Roles) = UserBusinessDtoImpl(
        login = uiDto.login,
        password = uiDto.password,
        name = uiDto.name,
        surname = uiDto.surname,
        lastname = uiDto.lastname,
        address = uiDto.address,
        email = uiDto.email,
        role = role
    )
}