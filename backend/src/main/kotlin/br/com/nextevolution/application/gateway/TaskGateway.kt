package br.com.nextevolution.application.gateway

import br.com.nextevolution.domain.Task

/**
 * Gateway interface for Task persistence operations.
 */
interface TaskGateway {
    fun save(task: Task): Task
    fun findById(id: Long): Task?
    fun findAll(): List<Task>
    fun deleteById(id: Long)
} 