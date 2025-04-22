package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.CreateTaskUseCase
import br.com.nextevolution.application.gateway.TaskGateway
import br.com.nextevolution.domain.Task
import org.springframework.stereotype.Service

/**
 * Implementation of CreateTaskUseCase, delegating to TaskGateway.
 */
@Service
class CreateTaskUseCaseImpl(
    private val gateway: TaskGateway
) : CreateTaskUseCase {
    override fun execute(task: Task): Task = gateway.save(task)
} 