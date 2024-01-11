package com.example.nepekariproject.services.validation.account

import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.exception.DataBaseException
import com.example.nepekariproject.services.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountValidationServiceImpl: AccountValidationService {
    @Autowired
    private lateinit var userService: UserService

    private val MIN_SIZE_LOGIN = 6
    private val MAX_SIZE_LOGIN = 32
    private val MIN_SIZE_PAS = 8
    private val MAX_SIZE_PAS = 32

    //TODO подумать над тем, чтобы сделать отправляемую форму классом использовать в ней BindingResult и интерфес Validator
    override fun validate(target: UserBusinessDto): List<DataBaseException> {
        val errors = mutableListOf<DataBaseException>()
        if (target.getLogin().length < MIN_SIZE_LOGIN || target.getLogin().length > MAX_SIZE_LOGIN)
            errors.add(DataBaseException("Поле \"логин\" должно быть размером от $MIN_SIZE_LOGIN до $MAX_SIZE_LOGIN символов"))
        if (userService.getUser(target.getLogin()) != null)
            errors.add(DataBaseException("Такой логин уже используется!"))

        if (target.getPassword().length < MIN_SIZE_PAS || target.getPassword().length > MAX_SIZE_PAS)
            errors.add(DataBaseException("Поле \"пароль\" должно быть размером от $MIN_SIZE_PAS до $MAX_SIZE_PAS символов"))

        return errors
    }

}