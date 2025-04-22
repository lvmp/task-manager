package br.com.nextevolution.application.usecase

/**
 * Use case for deleting a Task by its ID.
 */
interface DeleteTaskUseCase {
    fun execute(id: Long)
} 