package br.com.nextevolution.infrastructure.persistence

import br.com.nextevolution.domain.Priority
import br.com.nextevolution.domain.Status
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tasks")
data class TaskEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,
    val description: String,

    @Enumerated(EnumType.STRING)
    val priority: Priority,

    val dueDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    val status: Status
) 