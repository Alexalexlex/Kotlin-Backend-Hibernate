package com.alex.relocate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.alex.relocate.db.entity")
class RelocateApplication

fun main(args: Array<String>) {
	runApplication<RelocateApplication>(*args)
}
