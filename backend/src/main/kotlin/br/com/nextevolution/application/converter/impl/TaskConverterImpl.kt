package br.com.nextevolution.application.converter.impl

import br.com.nextevolution.application.converter.TaskConverter
import br.com.nextevolution.domain.Task
import br.com.nextevolution.infrastructure.entity.TaskEntity
import org.springframework.stereotype.Component

@Component
class TaskConverterImpl : TaskConverter {
    override fun toEntity(domain: Task): TaskEntity = TaskEntity(
        id = domain.id,
        title = domain.title,
        description = domain.description,
        priority = domain.priority,
        dueDate = domain.dueDate,
        status = domain.status
    )

    override fun toDomain(entity: TaskEntity): Task = Task(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        priority = entity.priority,
        dueDate = entity.dueDate,
        status = entity.status
    )
} 