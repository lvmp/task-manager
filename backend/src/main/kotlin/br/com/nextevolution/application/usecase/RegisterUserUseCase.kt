package br.com.nextevolution.application.usecase

import br.com.nextevolution.domain.User

/**
 * Use case for registering a new User (with password encryption).
 */
interface RegisterUserUseCase {
    fun execute(user: User): User
} 