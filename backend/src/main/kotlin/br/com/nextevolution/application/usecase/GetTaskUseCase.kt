package br.com.nextevolution.application.usecase

import br.com.nextevolution.domain.Task

/**
 * Use case for retrieving a Task by its ID.
 */
interface GetTaskUseCase {
    fun execute(id: Long): Task?
} 