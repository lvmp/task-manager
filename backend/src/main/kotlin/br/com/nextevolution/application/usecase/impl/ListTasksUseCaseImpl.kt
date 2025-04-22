package br.com.nextevolution.application.usecase.impl

import br.com.nextevolution.application.usecase.ListTasksUseCase
import br.com.nextevolution.application.gateway.TaskGateway
import br.com.nextevolution.domain.Task
import org.springframework.stereotype.Service

@Service
class ListTasksUseCaseImpl(
    private val gateway: TaskGateway
) : ListTasksUseCase {
    override fun execute(): List<Task> = gateway.findAll()
} 