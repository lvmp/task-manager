package br.com.nextevolution.infrastructure.api.dto

import br.com.nextevolution.domain.Task
import br.com.nextevolution.domain.Status
import br.com.nextevolution.domain.Priority
import java.time.LocalDateTime

/**
 * Request body for creating a new Task.
 */
data class CreateTaskRequest(
    val title: String,
    val description: String,
    val priority: Priority,
    val dueDate: LocalDateTime
) 