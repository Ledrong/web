package com.example.nepekariproject.dao.user

import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.dto.user.UserBusinessDtoImpl
import org.springframework.stereotype.Repository

@Repository
class UserDaoStub: UserDao {
    override fun getUserByLogin(userLogin: String) = UserBusinessDtoImpl(
        123,
        "zenya",
        "\$2a\$12\$ShWWiQQvSWPOAnPudUVPSO7nZPv5yXmqa10T/Wz3Hd3guEWiBPBgy", //qwerty
    )
    override fun getUserById(userId: Long): UserBusinessDto {
        TODO("Not yet implemented")
    }

    override fun saveNewUser(user: UserBusinessDto) {
        TODO("Not yet implemented")
    }

    override fun updateInfoAboutUser(user: UserBusinessDto) {
        TODO("Not yet implemented")
    }
}