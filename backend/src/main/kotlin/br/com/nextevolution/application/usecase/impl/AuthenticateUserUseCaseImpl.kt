package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.AuthenticateUserUseCase
import br.com.nextevolution.application.gateway.UserGateway
import br.com.nextevolution.domain.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * Implementation of AuthenticateUserUseCase, validating user credentials.
 */
@Service
class AuthenticateUserUseCaseImpl(
    private val gateway: UserGateway,
    private val passwordEncoder: PasswordEncoder
) : AuthenticateUserUseCase {
    override fun execute(email: String, password: String): User? {
        val user = gateway.findByEmail(email) ?: return null
        return if (passwordEncoder.matches(password, user.password)) user else null
    }
} 