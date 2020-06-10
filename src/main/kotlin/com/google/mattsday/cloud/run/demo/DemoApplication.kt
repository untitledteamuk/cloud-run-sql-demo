package com.google.mattsday.cloud.run.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
@Entity
data class Customer(@Id @GeneratedValue var id: Long = 0, var name: String, var address: String)

interface CustomerDb : JpaRepository<Customer, Long> {
    fun findByNameContainingIgnoreCase(name: String): List<Customer>
}
