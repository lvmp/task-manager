package br.com.nextevolution.application.usecase

import br.com.nextevolution.domain.Task

/**
 * Use case for listing all tasks.
 */
interface ListTasksUseCase {
    fun execute(): List<Task>
} 