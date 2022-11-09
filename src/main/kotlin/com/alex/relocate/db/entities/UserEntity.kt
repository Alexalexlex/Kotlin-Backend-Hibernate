package com.alex.relocate.db.entities
import java.util.*
import javax.persistence.Table

@Table(name = "users")
data class UserEntity(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val id: UUID = UUID.randomUUID(),
)