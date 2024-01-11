package com.example.nepekariproject.services.validation.account

import com.example.nepekariproject.dto.user.UserBusinessDto
import com.example.nepekariproject.exception.DataBaseException

interface AccountValidationService {
    fun validate(target: UserBusinessDto): List<DataBaseException>
}