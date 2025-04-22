package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.ChangeTaskStatusUseCase
import br.com.nextevolution.application.gateway.TaskGateway
import br.com.nextevolution.domain.Status
import br.com.nextevolution.domain.Task
import org.springframework.stereotype.Service

/**
 * Implementation of ChangeTaskStatusUseCase, delegating to TaskGateway and updating task status.
 */
@Service
class ChangeTaskStatusUseCaseImpl(
    private val gateway: TaskGateway
) : ChangeTaskStatusUseCase {
    override fun execute(id: Long, newStatus: Status): Task? {
        val task: Task = gateway.findById(id) ?: return null
        val updated: Task = task.copy(status = newStatus)
        return gateway.save(updated)
    }
} 