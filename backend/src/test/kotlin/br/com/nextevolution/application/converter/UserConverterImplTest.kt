package br.com.nextevolution.application.converter.impl

import br.com.nextevolution.application.converter.impl.UserConverterImpl
import br.com.nextevolution.domain.User
import br.com.nextevolution.domain.Role
import br.com.nextevolution.infrastructure.entity.UserEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserConverterImplTest {
    private val converter = UserConverterImpl()

    @Test
    fun `toEntity should map domain User to UserEntity`() {
        val domain = User(
            id = 1L,
            name = "Alice",
            email = "alice@example.com",
            password = "secret",
            role = Role.USER
        )
        val entity = converter.toEntity(domain)
        assertEquals(domain.id, entity.id)
        assertEquals(domain.name, entity.name)
        assertEquals(domain.email, entity.email)
        assertEquals(domain.password, entity.password)
        assertEquals(domain.role, entity.role)
    }

    @Test
    fun `toDomain should map UserEntity to domain User`() {
        val entity = UserEntity(
            id = 2L,
            name = "Bob",
            email = "bob@example.com",
            password = "hash",
            role = Role.ADMIN,
            createdAt = null,
            updatedAt = null
        )
        val domain = converter.toDomain(entity)
        assertEquals(entity.id, domain.id)
        assertEquals(entity.name, domain.name)
        assertEquals(entity.email, domain.email)
        assertEquals(entity.password, domain.password)
        assertEquals(entity.role, domain.role)
    }
} 