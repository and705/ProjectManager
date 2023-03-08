package com.nd705.project_manager.controller;

import com.nd705.project_manager.model.Project;
import com.nd705.project_manager.model.Task;
import com.nd705.project_manager.payload.request.NewProjectRequest;
import com.nd705.project_manager.payload.request.TaskRequest;
import com.nd705.project_manager.repository.ProjectRepository;
import com.nd705.project_manager.security.service.project.ProjectService;
import com.nd705.project_manager.security.service.project.ProjectServiceImpl;
import com.nd705.project_manager.security.service.project.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class ProjectController {
@Autowired ProjectServiceImpl projectServiceImpl;
@Autowired
    TaskServiceImpl taskServiceImpl;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "user content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "admin content.";
    }

    @GetMapping("/auth")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String authAccess() {
        return "admin or user content";
    }

    //============================
    @GetMapping("/getHierarchy")
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Project> getProjectsHierarchy() {
        List<Project> rootProjects = projectServiceImpl.getProjectsHierarchy();
        return rootProjects;
    }

    @GetMapping("/getAll")
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Project> getAllProjects() {
        List<Project> allProjects = projectServiceImpl.getAllProjects();
        return allProjects;
    }

    @PostMapping("/projects")
    @PreAuthorize("hasRole('ADMIN')")
    public Project addNewProject(@RequestBody NewProjectRequest newProjectRequest) {
        Project project = projectServiceImpl.saveNewProject(newProjectRequest);
        return project;
    }

    @GetMapping("/projects/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Project getProject(@PathVariable long id) {
        Project project = projectServiceImpl.getProject(id);
        return project;
    }
    @PutMapping("/projects")
    @PreAuthorize("hasRole('ADMIN')")
    public Project updateProject(@RequestBody Project project) {
        projectServiceImpl.saveProject(project);
        return project;
    }
    @DeleteMapping("/projects/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProject(@PathVariable long id) {
        projectServiceImpl.deleteProject(id);
        return "Project with ID = " + id + " was deleted";
    }



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
        Task task = taskServiceImpl.getTask(id);
        System.out.println("============="+task.getTaskStatus().toString());
        if (task.getTaskStatus().equals("new")){
            task.setTaskStatus("progress");
        } else if (task.getTaskStatus().equals("progress")){
            task.setTaskStatus("done");
        }

        taskServiceImpl.updateTask(task);
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