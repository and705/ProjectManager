
package com.nd705.project_manager.service.project;

import com.nd705.project_manager.model.Task;
import com.nd705.project_manager.payload.request.TaskRequest;
import com.nd705.project_manager.repository.ProjectRepository;
import com.nd705.project_manager.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveNewTask(TaskRequest taskRequest) {
        Task task = new Task();

        task.setTaskName(taskRequest.getTaskName());
        task.setTaskType(taskRequest.getTaskType());
        task.setTaskInfo(taskRequest.getTaskInfo());
        task.setProject(projectRepository.getReferenceById(taskRequest.getProjectId()));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        task.setTaskOwner(auth.getName());
        task.setTaskDateOfCreate(LocalDateTime.now());
        task.setTaskStatus("new");

        taskRepository.save(task);
        return  task;
    }

    @Override
    public Task getTask(long id) {
        Task task = null;
        Optional<Task> tsk = taskRepository.findById(id);
        if(tsk.isPresent()){
            task = tsk.get();
        }
        return task;
    }

    @Override
    public String deleteTask(long id) {
        Task task = taskRepository.findById(id).get();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        String result;
        if (task.getTaskOwner().equals(user)) {
            taskRepository.deleteById(id);
            result = "Project with ID = " + id + " was deleted";
        } else {
            result = "Project with ID = " + id + " can be deleted only by user: " + user;
        }
        return result;

    }

    @Override
    public Task updateTask(Task task) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        task.setTaskEditor(auth.getName());
        taskRepository.save(task);
        return task;
    }

    @Override
    public String deleteTaskAdmin(long id) {
        taskRepository.deleteById(id);
        return "Project with ID = " + id + " was deleted";
    }

    @Override
    public Task updateTaskStatus(Task task) {
        if (task.getTaskStatus().equals("new")){
            task.setTaskStatus("progress");
        } else if (task.getTaskStatus().equals("progress")){
            task.setTaskStatus("done");
        }
        task.setTaskDateOfStatusChange(LocalDateTime.now());
        taskRepository.save(task);
        return task;
    }


}


