package br.com.nextevolution.application.usecase

import br.com.nextevolution.domain.User

/**
 * Use case for authenticating a user by email and password.
 */
interface AuthenticateUserUseCase {
    fun execute(email: String, password: String): User?
} 