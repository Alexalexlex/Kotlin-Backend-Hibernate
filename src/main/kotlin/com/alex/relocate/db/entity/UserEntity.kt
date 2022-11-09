package com.alex.relocate.db.entity

import java.util.*
import javax.persistence.*

@Entity
data class UserEntity(
    val firstName: String,
    val lastName: String,
    @Column(unique = true)
    val email: String,
    val password: String,
    @Id
    val id: UUID = UUID.randomUUID(),
) {
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var addresses: List<UserAddressEntity>? = null
}