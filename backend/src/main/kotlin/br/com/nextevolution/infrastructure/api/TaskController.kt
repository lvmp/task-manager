package br.com.nextevolution.infrastructure.api

import br.com.nextevolution.application.usecase.CreateTaskUseCase
import br.com.nextevolution.application.usecase.GetTaskUseCase
import br.com.nextevolution.application.usecase.ListTasksUseCase
import br.com.nextevolution.application.usecase.UpdateTaskUseCase
import br.com.nextevolution.application.usecase.DeleteTaskUseCase
import br.com.nextevolution.application.usecase.ChangeTaskStatusUseCase
import br.com.nextevolution.application.converter.TaskConverter
import br.com.nextevolution.infrastructure.api.dto.request.CreateTaskRequest
import br.com.nextevolution.infrastructure.api.dto.request.UpdateTaskRequest
import br.com.nextevolution.infrastructure.api.dto.request.ChangeTaskStatusRequest
import br.com.nextevolution.infrastructure.api.dto.response.TaskResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val listTasksUseCase: ListTasksUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val changeTaskStatusUseCase: ChangeTaskStatusUseCase,
    private val converter: TaskConverter
) {

    @PostMapping
    fun create(@RequestBody req: CreateTaskRequest): TaskResponse {
        val domain = converter.fromCreateRequest(req)
        val saved = createTaskUseCase.execute(domain)
        return converter.toResponse(saved)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): TaskResponse? =
        getTaskUseCase.execute(id)?.let(converter::toResponse)

    @GetMapping
    fun list(): List<TaskResponse> =
        listTasksUseCase.execute().map(converter::toResponse)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody req: UpdateTaskRequest): TaskResponse {
        val existing = getTaskUseCase.execute(id)!!
        val toUpdate = converter.fromUpdateRequest(existing, req)
        val updated = updateTaskUseCase.execute(toUpdate)
        return converter.toResponse(updated)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        deleteTaskUseCase.execute(id)
    }

    @PatchMapping("/{id}/status")
    fun changeStatus(@PathVariable id: Long, @RequestBody req: ChangeTaskStatusRequest): TaskResponse? =
        changeTaskStatusUseCase.execute(id, req.status)?.let(converter::toResponse)
} 