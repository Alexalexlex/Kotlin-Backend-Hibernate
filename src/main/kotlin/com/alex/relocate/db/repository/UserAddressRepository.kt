package com.alex.relocate.db.repository

import com.alex.relocate.db.entity.UserAddressEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserAddressRepository : CrudRepository<UserAddressEntity, UUID>