package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.RegisterUserUseCase
import br.com.nextevolution.application.gateway.UserGateway
import br.com.nextevolution.domain.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * Implementation of RegisterUserUseCase, encrypting password and saving user via gateway.
 */
@Service
class RegisterUserUseCaseImpl(
    private val gateway: UserGateway,
    private val passwordEncoder: PasswordEncoder
) : RegisterUserUseCase {
    override fun execute(user: User): User {
        // Encrypt user password before saving
        val secure = user.copy(password = passwordEncoder.encode(user.password))
        return gateway.save(secure)
    }
} 