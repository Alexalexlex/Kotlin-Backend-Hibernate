package com.alex.relocate.db.entity

import java.util.*
import javax.persistence.*

@Entity
data class UserAddressEntity(
    val address: String,
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    val user: UserEntity,
    @Id
    val id: UUID = UUID.randomUUID()
)