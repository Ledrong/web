package com.example.nepekariproject.config

import com.example.nepekariproject.services.security.userDetails.MyDatabaseUserDetailsService
import com.example.nepekariproject.sevletFilters.TechBreakFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.cors().and()
        .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .addFilterBefore(techBreakFilter(), BasicAuthenticationFilter::class.java)
        .authorizeRequests()
            .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
            .antMatchers("/catalog", "/catalog/**", "/api/v1/catalog", "/api/v1/catalog/**",
                "/register", "/api/v1/register",
                "/img/**", "/css/**",
                "/auth", "/auth/**", "/auth/login", "/api/v1/auth", "/api/v1/auth/**", "/api/v1/auth/login").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .defaultSuccessUrl("/catalog", true)
            .permitAll()
            .and()
        .logout()
            .logoutSuccessUrl("/index")
            .permitAll()
            .and()
        .csrf().disable()
        .httpBasic()
    }

    @Bean
    fun techBreakFilter(): TechBreakFilter {
        return TechBreakFilter()
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return MyDatabaseUserDetailsService()
    }

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}