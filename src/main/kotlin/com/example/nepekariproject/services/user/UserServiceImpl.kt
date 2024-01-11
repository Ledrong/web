package com.example.nepekariproject.services.user

import com.example.nepekariproject.dao.user.UserDao
import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.exception.BaseException
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserServiceImpl: UserService {
    @Autowired
    private lateinit var userDao: UserDao

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    private val logger = LogManager.getLogger(this::class.java)

    override fun getUser(login: String) =
    try { userDao.getUserByLogin(login) }
    catch (ex: BaseException) {
        logger.error("Cant getUser by login = $login")
        null
    }

    override fun getUser(id: Long) =
    try { userDao.getUserById(id) }
    catch (ex: BaseException) {
        logger.error("Cant getUser by id = $id")
        null
    }

    override fun updateUser(userBusinessDto: UserBusinessDto) {
        try { userDao.updateInfoAboutUser(userBusinessDto) }
        catch (ex: BaseException) {
            logger.error("Cant update info about user with id = ${userBusinessDto.getId()}")
        }
    }

    override fun registerUser(userBusinessDto: UserBusinessDto) {
        userBusinessDto.setPassword(passwordEncoder.encode(userBusinessDto.getPassword()))
        try { userDao.saveNewUser(userBusinessDto) }
        catch (ex: BaseException) {
            logger.error("Cant save new user with login = ${userBusinessDto.getLogin()}")
        }
    }
}