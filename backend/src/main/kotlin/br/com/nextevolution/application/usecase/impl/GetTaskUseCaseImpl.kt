package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.GetTaskUseCase
import br.com.nextevolution.application.gateway.TaskGateway
import br.com.nextevolution.domain.Task
import org.springframework.stereotype.Service

/**
 * Implementation of GetTaskUseCase, delegating to TaskGateway.
 */
@Service
class GetTaskUseCaseImpl(
    private val gateway: TaskGateway
) : GetTaskUseCase {
    override fun execute(id: Long): Task? = gateway.findById(id)
} 