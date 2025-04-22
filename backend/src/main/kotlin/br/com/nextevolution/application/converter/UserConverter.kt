package br.com.nextevolution.application.converter

import br.com.nextevolution.domain.User
import br.com.nextevolution.infrastructure.entity.UserEntity

/**
 * Conversor para transformar entre o objeto de domínio User e a entidade de persistência UserEntity.
 */
interface UserConverter {
    fun toEntity(domain: User): UserEntity
    fun toDomain(entity: UserEntity): User
} 