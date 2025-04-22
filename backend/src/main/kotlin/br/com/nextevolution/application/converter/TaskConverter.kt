package br.com.nextevolution.application.converter

import br.com.nextevolution.domain.Task
import br.com.nextevolution.infrastructure.entity.TaskEntity

/**
 * Conversor para transformar entre objeto de domínio Task e entidade de persistência TaskEntity.
 */
interface TaskConverter {
    fun toEntity(domain: Task): TaskEntity
    fun toDomain(entity: TaskEntity): Task
} 