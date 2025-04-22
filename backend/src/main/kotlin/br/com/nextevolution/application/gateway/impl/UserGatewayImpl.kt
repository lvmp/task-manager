package br.com.nextevolution.application.gateway.impl

import br.com.nextevolution.application.gateway.UserGateway
import br.com.nextevolution.application.converter.UserConverter
import br.com.nextevolution.domain.User
import br.com.nextevolution.infrastructure.entity.UserEntity
import br.com.nextevolution.infrastructure.repository.UserRepository
import org.springframework.stereotype.Component

/**
 * Persistence adapter for User operations, implementing UserGateway.
 */
@Component
class UserGatewayImpl(
    private val repository: UserRepository,
    private val converter: UserConverter
) : UserGateway {

    override fun save(user: User): User {
        val entity: UserEntity = converter.toEntity(user)
        val saved: UserEntity = repository.save(entity)
        return converter.toDomain(saved)
    }

    override fun findById(id: Long): User? =
        repository.findById(id).map(converter::toDomain).orElse(null)

    override fun findByEmail(email: String): User? =
        repository.findByEmail(email).map(converter::toDomain).orElse(null)

    override fun findAll(): List<User> =
        repository.findAll().map(converter::toDomain)

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }
} 