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

    override fun fromCreateRequest(req: br.com.nextevolution.infrastructure.api.dto.CreateTaskRequest): Task = Task(
        id = null,
        title = req.title,
        description = req.description,
        priority = req.priority,
        dueDate = req.dueDate,
        status = br.com.nextevolution.domain.Status.PENDING
    )

    override fun fromUpdateRequest(existing: Task, req: br.com.nextevolution.infrastructure.api.dto.UpdateTaskRequest): Task =
        existing.copy(
            title = req.title,
            description = req.description,
            priority = req.priority,
            dueDate = req.dueDate
        )

    override fun fromChangeStatusRequest(req: br.com.nextevolution.infrastructure.api.dto.ChangeTaskStatusRequest, existing: Task): Task =
        existing.copy(status = req.status)

    override fun toResponse(domain: Task): br.com.nextevolution.infrastructure.api.dto.TaskResponse =
        br.com.nextevolution.infrastructure.api.dto.TaskResponse.fromDomain(domain)
} 