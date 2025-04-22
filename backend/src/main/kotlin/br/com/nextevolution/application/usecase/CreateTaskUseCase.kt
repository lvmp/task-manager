package br.com.nextevolution.application.usecase

import br.com.nextevolution.domain.Task

/**
 * Use case for creating a new Task.
 */
interface CreateTaskUseCase {
    fun execute(task: Task): Task
} 