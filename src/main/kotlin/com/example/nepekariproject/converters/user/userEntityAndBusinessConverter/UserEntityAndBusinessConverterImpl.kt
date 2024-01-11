package com.example.nepekariproject.converters.user.userEntityAndBusinessConverter

import com.example.nepekariproject.dto.address.AddressDto
import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.dto.user.UserBusinessDtoImpl
import com.example.nepekariproject.entity.user.UserEntity
import com.example.nepekariproject.enumerations.Roles
import com.example.nepekariproject.enumerations.TariffPlan
import org.springframework.stereotype.Component
import java.sql.Date

@Component
class UserEntityAndBusinessConverterImpl: UserEntityAndBusinessConverter {
    override fun convert(dto: UserEntity): UserBusinessDto {
        return UserBusinessDtoImpl(
            id = dto.id,
            login = dto.login,
            password = dto.password,
            name = dto.name,
            surname = dto.surname,
            lastname = dto.lastname,
            address = AddressDto(
                dto.addressStreet,
                dto.addressCity,
                dto.addressZip
            ),
            regDate = java.util.Date(dto.regdate.time),
            email = dto.email ?: "",
            tariffPlan = TariffPlan.findTariffPlanByCode(dto.tariffPlan),
            role = Roles.findRoleByString(dto.role)
        )
    }

    override fun convert(dto: UserBusinessDto): UserEntity {
        return UserEntity(
            id = dto.getId(),
            login = dto.getLogin(),
            password = dto.getPassword(),
            name = dto.getName(),
            surname = dto.getSurname(),
            lastname = dto.getLastName(),
            addressCity = dto.getAddress().city,
            addressStreet = dto.getAddress().street,
            addressZip = dto.getAddress().zip,
            regdate = Date(dto.getRegDate().time),
            email = dto.getEmail(),
            tariffPlan = dto.getTariffPlan().code,
            role = dto.getRoles().first().role
        )
    }

}