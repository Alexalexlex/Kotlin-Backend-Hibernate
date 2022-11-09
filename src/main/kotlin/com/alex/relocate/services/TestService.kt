package com.alex.relocate.services

import com.alex.relocate.db.entity.UserAddressEntity
import com.alex.relocate.db.entity.UserEntity
import com.alex.relocate.db.repository.UserRepository
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TestService(
    val userRepository: UserRepository
) {
    @EventListener(ContextRefreshedEvent::class)
    @Transactional
    fun onInit() {
        val entity = UserEntity(
            "1", "2", "3", "4"
        )
        entity.addresses = listOf(
            UserAddressEntity("test 1", entity),
            UserAddressEntity("test 2", entity)
        )
        userRepository.save(entity)
        userRepository.findAll().forEach { aaa ->
            println("-------")
            println(aaa)
            println(aaa.addresses)
            println("-------")
        }
    }
}