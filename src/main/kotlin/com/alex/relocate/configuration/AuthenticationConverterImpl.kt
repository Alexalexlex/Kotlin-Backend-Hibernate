package com.alex.relocate.configuration

import com.alex.relocate.common.AuthenticationToken
import com.alex.relocate.services.TokenService
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationConverter
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class AuthenticationConverterImpl(
    val tokenService: TokenService
): AuthenticationConverter {
    override fun convert(request: HttpServletRequest): Authentication {
        val token = request.getHeader("token")
        val principal = tokenService.validate(token)

        return AuthenticationToken(token, principal)
    }
}