package com.nd705.project_manager.controller;

import com.nd705.project_manager.model.Task;
import com.nd705.project_manager.payload.request.TaskRequest;
import com.nd705.project_manager.service.project.ProjectServiceImpl;
import com.nd705.project_manager.service.project.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskServiceImpl taskServiceImpl;

    @PostMapping("/tasks")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Task addNewTask(@RequestBody TaskRequest taskRequest) {
        Task task = taskServiceImpl.saveNewTask(taskRequest);
        return task;
    }
    @GetMapping("/tasks/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Task getTask(@PathVariable long id) {
        Task task = taskServiceImpl.getTask(id);
        return task;
    }


    @GetMapping("/taskUpdateStatus/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Task updateTaskStatus(@PathVariable long id) {
        Task task = taskServiceImpl.updateTaskStatus(taskServiceImpl.getTask(id));
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    @PreAuthorize("hasRole('USER')")
    public String deleteTask(@PathVariable long id) {
        return taskServiceImpl.deleteTask(id);
    }

    @DeleteMapping("/tasksAdmin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteTaskAdmin(@PathVariable long id) {
        return taskServiceImpl.deleteTaskAdmin(id);
    }
    @PutMapping("/tasks")
    @PreAuthorize("hasRole('ADMIN')")
    public Task editTask(@RequestBody Task task) {
        taskServiceImpl.updateTask(task);
        return task;
    }

    @GetMapping("/getAllTasks")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Iterable<Task> getAllTask() {
        return taskServiceImpl.getAllTasks();
    }
}

