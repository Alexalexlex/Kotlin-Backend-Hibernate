package com.alex.relocate.db.entities
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UserEntity(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    @Id
    val id: UUID = UUID.randomUUID(),
)