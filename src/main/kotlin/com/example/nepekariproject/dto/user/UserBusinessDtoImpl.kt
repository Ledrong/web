package com.example.nepekariproject.dto.user

import com.example.nepekariproject.dto.address.AddressDto
import com.example.nepekariproject.enumerations.Roles
import com.example.nepekariproject.enumerations.TariffPlan
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserBusinessDtoImpl(
    private var id: Long = 0L,
    private var login: String = "",
    private var password: String = "",
    private var name: String = "",
    private var surname: String = "",
    private var lastname: String = "",
    private var address: AddressDto = AddressDto(),
    private var regDate: Date = Date(),
    private var email: String = "",
    private var tariffPlan: TariffPlan = TariffPlan.DEFAULT,
    private var role: Roles = Roles.UNKNOWN
): UserBusinessDto {
    override fun getId() = id
    override fun getLogin() = login
    override fun getPassword() = password
    override fun getName() = name
    override fun getSurname() = surname
    override fun getLastName() = lastname
    override fun getAddress() = address
    override fun getRegDate() = regDate
    override fun getEmail() = email
    override fun getTariffPlan() = tariffPlan
    override fun getRoles() = listOf(role)

    override fun setId(id: Long) = this.apply {
        this.id = id
    }

    override fun setLogin(login: String) = this.apply {
        this.login = login
    }

    override fun setPassword(password: String) = this.apply {
        this.password = password
    }

    override fun setName(name: String) = this.apply {
        this.name = name
    }

    override fun setSurname(surname: String) = this.apply {
        this.surname = surname
    }

    override fun setLastName(lastname: String) = this.apply {
        this.lastname = lastname
    }

    override fun setAddress(address: AddressDto) = this.apply {
        this.address = address
    }

    override fun setEmail(email: String) = this.apply {
        this.email = email
    }

    override fun equals(other: Any?): Boolean {
        val otherUser = other as? UserBusinessDto ?: return false

        return this.getId() == otherUser.getId() &&
        this.getLogin() == otherUser.getLogin() &&
        this.getPassword() == otherUser.getPassword() &&
        this.getName() == otherUser.getName() &&
        this.getSurname() == otherUser.getSurname() &&
        this.getLastName() == otherUser.getLastName()
    }

}