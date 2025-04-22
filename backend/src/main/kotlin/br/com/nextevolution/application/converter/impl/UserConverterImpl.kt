package br.com.nextevolution.application.converter.impl

import br.com.nextevolution.application.converter.UserConverter
import br.com.nextevolution.domain.User
import br.com.nextevolution.infrastructure.entity.UserEntity

/**
 * Implementation of UserConverter, mapping between domain and persistence layers.
 */
class UserConverterImpl : UserConverter {
    override fun toEntity(domain: User): UserEntity = UserEntity(
        id = domain.id,
        name = domain.name,
        email = domain.email,
        password = domain.password,
        role = domain.role
    )

    override fun toDomain(entity: UserEntity): User = User(
        id = entity.id,
        name = entity.name,
        email = entity.email,
        password = entity.password,
        role = entity.role
    )
} 