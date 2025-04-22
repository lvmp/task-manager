package br.com.nextevolution.application.usecase

import br.com.nextevolution.domain.Task

/**
 * Use case for updating an existing Task.
 */
interface UpdateTaskUseCase {
    fun execute(task: Task): Task
} 