package com.alex.relocate.db.repositories

import com.alex.relocate.db.entities.UserEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<UserEntity, UUID> {
    fun findOneByEmail(email: String): UserEntity?
}