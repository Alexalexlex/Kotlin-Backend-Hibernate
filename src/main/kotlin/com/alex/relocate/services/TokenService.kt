package com.alex.relocate.services

import com.alex.relocate.common.AuthPrincipal
import com.alex.relocate.common.UserRole
import com.alex.relocate.db.entities.UserEntity
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct

@Service
class TokenService {
    @Value("\${app.jwt.secret}")
    private lateinit var jwtSecret: String

    private lateinit var algorithm: Algorithm
    private lateinit var verifier: JWTVerifier
    private val iss = "Alex-backend"

    @PostConstruct
    fun init() {
        algorithm = Algorithm.HMAC256(jwtSecret)
        verifier = JWT.require(algorithm).withIssuer(iss).build()
    }


    fun generate(user: UserEntity): String {
        val jwt = JWT.create()
            .withIssuer(iss)
            .withClaim("userId", user.id.toString())
            .withClaim("role", user.role.toString())

        return jwt.sign(algorithm)
    }

    fun validate(token: String): AuthPrincipal {
        val jwt = verifier.verify(token)
        val id = UUID.fromString(jwt.getClaim("userId").asString())
        val role = UserRole.valueOf(jwt.getClaim("role").asString())

        return AuthPrincipal(id, role)
    }
}