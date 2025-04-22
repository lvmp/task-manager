package br.com.nextevolution.domain

import java.time.LocalDateTime

/**
 * Entidade de domínio representando uma tarefa, sem anotações de persistência.
 */
data class Task(
    val id: Long? = null,
    val title: String,
    val description: String,
    val priority: Priority,
    val dueDate: LocalDateTime,
    val status: Status
) 