package br.com.nextevolution.application.usecase

import br.com.nextevolution.domain.Status
import br.com.nextevolution.domain.Task

/**
 * Use case for changing the status of a Task.
 */
interface ChangeTaskStatusUseCase {
    fun execute(id: Long, newStatus: Status): Task?
} 