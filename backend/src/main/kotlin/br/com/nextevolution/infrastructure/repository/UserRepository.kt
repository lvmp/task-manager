package br.com.nextevolution.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import br.com.nextevolution.infrastructure.entity.UserEntity

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): java.util.Optional<UserEntity>
} 