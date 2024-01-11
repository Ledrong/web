package com.example.nepekariproject.exception.handler

import com.example.nepekariproject.exception.DataBaseException
import com.example.nepekariproject.exception.UnavailableTechnicalException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionHandler: ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class)
    fun handleOtherException(ex: Exception, request: WebRequest) =
        ResponseEntity(MessageExceptionHandler(Date(), "Unknown exception", "-"),
            HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR)

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(ex: AccessDeniedException, request: WebRequest) =
        ResponseEntity(MessageExceptionHandler(Date(), "Access denied", "-"),
            HttpHeaders(), HttpStatus.FORBIDDEN)

    @ExceptionHandler(UnavailableTechnicalException::class)
    fun handleTechnicalException(ex: UnavailableTechnicalException, request: WebRequest) =
        ResponseEntity(MessageExceptionHandler(ex), HttpHeaders(), HttpStatus.BAD_GATEWAY)

    @ExceptionHandler(DataBaseException::class)
    fun handleDataBaseException(ex: DataBaseException, request: WebRequest) =
        ResponseEntity(MessageExceptionHandler(ex), HttpHeaders(), HttpStatus.GONE)
}