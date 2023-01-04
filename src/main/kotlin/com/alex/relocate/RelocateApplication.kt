package com.alex.relocate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude= [UserDetailsServiceAutoConfiguration::class])
class RelocateApplication

fun main(args: Array<String>) {
	runApplication<RelocateApplication>(*args)
}
