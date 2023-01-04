package com.alex.relocate.db.entities
import com.alex.relocate.common.UserRole
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UserEntity(
    val firstName: String,
    val lastName: String,
    val email: String,
    val passwordHash: String,
    val role: UserRole,
    @Id
    val id: UUID = UUID.randomUUID(),
)