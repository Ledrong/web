package com.example.nepekariproject.exception

class UnavailableTechnicalException(
    metaData: String?
): BaseException("MSG_UNAVAILABLE_EXCEPTION", metaData ?: "Unavailable technical error")