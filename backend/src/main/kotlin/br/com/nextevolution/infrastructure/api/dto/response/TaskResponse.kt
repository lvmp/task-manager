package br.com.nextevolution.infrastructure.api.dto

import br.com.nextevolution.domain.Task
import br.com.nextevolution.domain.Priority
import br.com.nextevolution.domain.Status
import java.time.LocalDateTime

/**
 * Response DTO for Task data.
 */
data class TaskResponse(
    val id: Long?,
    val title: String,
    val description: String,
    val priority: Priority,
    val dueDate: LocalDateTime,
    val status: Status
) {
    companion object {
        fun fromDomain(task: Task): TaskResponse = TaskResponse(
            id = task.id,
            title = task.title,
            description = task.description,
            priority = task.priority,
            dueDate = task.dueDate,
            status = task.status
        )
    }
} 