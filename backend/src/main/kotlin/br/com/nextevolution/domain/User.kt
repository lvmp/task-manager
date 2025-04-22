package br.com.nextevolution.domain

/**
 * Domain entity representing a system user.
 */
data class User(
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,
    val role: Role
) 