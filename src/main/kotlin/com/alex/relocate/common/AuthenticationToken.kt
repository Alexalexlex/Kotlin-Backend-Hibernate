package com.alex.relocate.common

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class AuthenticationToken(
    private val jwtToken: String,
    private val principal: AuthPrincipal
) : AbstractAuthenticationToken(
    listOf(GrantedAuthority { "ROLE_${principal.role}" })
) {
    override fun getCredentials(): Any {
        return jwtToken
    }

    override fun getPrincipal(): Any {
        return principal
    }

}