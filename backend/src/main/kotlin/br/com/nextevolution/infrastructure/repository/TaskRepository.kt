package br.com.nextevolution.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<TaskEntity, Long> 