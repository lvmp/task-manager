package br.com.nextevolution.application.gateway.impl

import br.com.nextevolution.application.gateway.TaskGateway
import br.com.nextevolution.application.converter.TaskConverter
import br.com.nextevolution.domain.Task
import br.com.nextevolution.infrastructure.entity.TaskEntity
import br.com.nextevolution.infrastructure.repository.TaskRepository
import org.springframework.stereotype.Component

/**
 * Implementation of TaskGateway using Spring Data repository and TaskConverter.
 */
@Component
class TaskGatewayImpl(
    private val repository: TaskRepository,
    private val converter: TaskConverter
) : TaskGateway {

    override fun save(task: Task): Task {
        val entity: TaskEntity = converter.toEntity(task)
        val saved: TaskEntity = repository.save(entity)
        return converter.toDomain(saved)
    }

    override fun findById(id: Long): Task? =
        repository.findById(id)
            .map(converter::toDomain)
            .orElse(null)

    override fun findAll(): List<Task> =
        repository.findAll().map(converter::toDomain)

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }
} 