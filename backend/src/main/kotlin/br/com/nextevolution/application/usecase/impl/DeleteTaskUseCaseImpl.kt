package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.DeleteTaskUseCase
import br.com.nextevolution.application.gateway.TaskGateway
import org.springframework.stereotype.Service

/**
 * Implementation of DeleteTaskUseCase, delegating to TaskGateway.
 */
@Service
class DeleteTaskUseCaseImpl(
    private val gateway: TaskGateway
) : DeleteTaskUseCase {
    override fun execute(id: Long) {
        gateway.deleteById(id)
    }
} 