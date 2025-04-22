package br.com.nextevolution.application.usecase.impl

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.password.PasswordEncoder
import br.com.nextevolution.application.gateway.UserGateway
import br.com.nextevolution.domain.User
import br.com.nextevolution.domain.Role

class AuthenticateUserUseCaseImplTest {
    private val gateway = mockk<UserGateway>()
    private val encoder = mockk<PasswordEncoder>()
    private val useCase = AuthenticateUserUseCaseImpl(gateway, encoder)

    @Test
    fun `should return user when credentials match`() {
        val email = "test@example.com"
        val rawPassword = "raw"
        val hashed = "hashed"
        val user = User(id = 1L, name = "Test", email = email, password = hashed, role = Role.USER)

        every { gateway.findByEmail(email) } returns user
        every { encoder.matches(rawPassword, hashed) } returns true

        val result = useCase.execute(email, rawPassword)

        assertNotNull(result)
        assertEquals(user, result)
        verify { gateway.findByEmail(email) }
        verify { encoder.matches(rawPassword, hashed) }
    }

    @Test
    fun `should return null when user not found`() {
        val email = "noone@example.com"

        every { gateway.findByEmail(email) } returns null

        val result = useCase.execute(email, "any")

        assertNull(result)
        verify { gateway.findByEmail(email) }
    }

    @Test
    fun `should return null when password does not match`() {
        val email = "test@example.com"
        val hashed = "hashed"
        val rawPassword = "wrong"
        val user = User(id = 1L, name = "Test", email = email, password = hashed, role = Role.USER)

        every { gateway.findByEmail(email) } returns user
        every { encoder.matches(rawPassword, hashed) } returns false

        val result = useCase.execute(email, rawPassword)

        assertNull(result)
        verify { gateway.findByEmail(email) }
        verify { encoder.matches(rawPassword, hashed) }
    }
} 