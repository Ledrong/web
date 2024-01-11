package com.example.nepekariproject.dto.user

import com.example.nepekariproject.dto.address.AddressDto
import com.example.nepekariproject.enumerations.Roles
import com.example.nepekariproject.enumerations.TariffPlan
import java.util.*

interface UserBusinessDto {
    fun getId(): Long
    fun getLogin(): String
    fun getPassword(): String
    fun getName(): String
    fun getSurname(): String
    fun getLastName(): String
    fun getAddress(): AddressDto
    fun getRegDate(): Date
    fun getEmail(): String
    fun getTariffPlan(): TariffPlan
    fun getRoles(): List<Roles>

    fun setId(id: Long): UserBusinessDto
    fun setLogin(login: String): UserBusinessDto
    fun setPassword(password: String): UserBusinessDto
    fun setName(name: String): UserBusinessDto
    fun setSurname(surname: String): UserBusinessDto
    fun setLastName(lastName: String): UserBusinessDto
    fun setAddress(address: AddressDto): UserBusinessDto
    fun setEmail(email: String): UserBusinessDto
}