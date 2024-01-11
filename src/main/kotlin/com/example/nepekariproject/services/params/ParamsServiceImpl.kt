package com.example.nepekariproject.services.params

import org.springframework.stereotype.Service

@Service
class ParamsServiceImpl: ParamsService {
    override fun isTechBreakEnabled(): Boolean {
        return false
    }
}