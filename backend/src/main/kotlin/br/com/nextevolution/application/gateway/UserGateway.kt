package br.com.nextevolution.application.gateway

import br.com.nextevolution.domain.User
import java.util.Optional

/**
 * Gateway interface for User persistence operations.
 */
interface UserGateway {
    fun save(user: User): User
    fun findById(id: Long): User?
    fun findByEmail(email: String): User?
    fun findAll(): List<User>
    fun deleteById(id: Long)
} 