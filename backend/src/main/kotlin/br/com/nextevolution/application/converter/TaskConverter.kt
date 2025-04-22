package br.com.nextevolution.application.converter

import br.com.nextevolution.domain.Task
import br.com.nextevolution.infrastructure.entity.TaskEntity

/**
 * Conversor para transformar entre objeto de domínio Task e entidade de persistência TaskEntity.
 */
interface TaskConverter {
    fun toEntity(domain: Task): TaskEntity
    fun toDomain(entity: TaskEntity): Task
    fun fromCreateRequest(req: br.com.nextevolution.infrastructure.api.dto.CreateTaskRequest): Task
    fun fromUpdateRequest(existing: Task, req: br.com.nextevolution.infrastructure.api.dto.UpdateTaskRequest): Task
    fun fromChangeStatusRequest(req: br.com.nextevolution.infrastructure.api.dto.ChangeTaskStatusRequest, existing: Task): Task
    fun toResponse(domain: Task): br.com.nextevolution.infrastructure.api.dto.TaskResponse
} 