package br.com.nextevolution.infrastructure.api.dto

import br.com.nextevolution.domain.Status

/**
 * Request body for changing a task's status.
 */
data class ChangeTaskStatusRequest(
    val status: Status
) 