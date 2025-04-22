package br.com.nextevolution.application.usecase.impl

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.password.PasswordEncoder
import br.com.nextevolution.domain.User
import br.com.nextevolution.domain.Role
import br.com.nextevolution.application.gateway.UserGateway

class RegisterUserUseCaseImplTest {
    private val gateway = mockk<UserGateway>(relaxed = true)
    private val encoder = mockk<PasswordEncoder>()
    private val useCase = RegisterUserUseCaseImpl(gateway, encoder)

    @Test
    fun `execute should encode password and save user`() {
        val user = User(
            id = null,
            name = "Test User",
            email = "test@example.com",
            password = "raw",
            role = Role.USER
        )
        every { encoder.encode("raw") } returns "encoded"
        val savedUser = user.copy(id = 1L, password = "encoded")
        every { gateway.save(savedUser) } returns savedUser

        val result = useCase.execute(user)

        assertNotNull(result.id)
        assertEquals("encoded", result.password)
        verify { encoder.encode("raw") }
        verify { gateway.save(savedUser) }
    }
} 