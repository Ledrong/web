package com.example.nepekariproject.sevletFilters

import com.example.nepekariproject.services.params.ParamsService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletResponse

class TechBreakFilter: Filter {
    @Autowired
    private lateinit var paramsService: ParamsService

    private val logger = LogManager.getLogger(this::class.java)

    @Override
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        when {
            paramsService.isTechBreakEnabled() ->  {
                logger.info("Service on techBreak")
                (response as HttpServletResponse?)?.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,
                    "Site in tech break")
            }
            else -> chain?.doFilter(request, response)
        }
    }
}