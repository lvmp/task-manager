package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.UpdateTaskUseCase
import br.com.nextevolution.application.gateway.TaskGateway
import br.com.nextevolution.domain.Task
import org.springframework.stereotype.Service

/**
 * Implementation of UpdateTaskUseCase, delegating to TaskGateway.
 */
@Service
class UpdateTaskUseCaseImpl(
    private val gateway: TaskGateway
) : UpdateTaskUseCase {
    override fun execute(task: Task): Task = gateway.save(task)
} 