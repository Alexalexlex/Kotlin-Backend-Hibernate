package com.alex.relocate.controllers

import com.alex.relocate.common.UserRole
import com.alex.relocate.db.entities.UserEntity
import com.alex.relocate.db.repositories.UserRepository
import com.alex.relocate.services.TokenService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.naming.AuthenticationException

@RestController()
class AuthController(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val tokenService: TokenService
) {
    @GetMapping("/auth/login")
    fun login(@RequestParam email: String, @RequestParam password: String): String {
        val user = userRepository.findOneByEmail(email) ?: throw UsernameNotFoundException(email)

        if (!passwordEncoder.matches(password, user.passwordHash)) {
            throw AuthenticationException()
        }

        return tokenService.generate(user)
    }

    @PostMapping("/auth/sign-up")
    fun signUp(@RequestBody req: UserCreateDTO): String {
        val passwordHash = passwordEncoder.encode(req.password)

        val user = userRepository.save(
            UserEntity(
                firstName = req.firstName,
                lastName = req.lastName,
                email = req.email,
                passwordHash = passwordHash,
                role = UserRole.USER
            )
        )

        return tokenService.generate(user)
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello"
    }

    data class UserCreateDTO(
        val email: String,
        val password: String,
        val firstName: String,
        val lastName: String,
    )
}