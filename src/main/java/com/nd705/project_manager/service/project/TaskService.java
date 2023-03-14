package com.nd705.project_manager.service.project;

import com.nd705.project_manager.model.Project;
import com.nd705.project_manager.model.Task;
import com.nd705.project_manager.payload.request.TaskRequest;

import java.util.List;

public interface TaskService {

    public Iterable<Task> getAllTasks();
    public Task saveNewTask(TaskRequest taskRequest);
    public Task updateTask(Task task);
    public Task getTask(long id);
    public String deleteTask(long id);
    public String deleteTaskAdmin(long id);
    public Task updateTaskStatus(Task task);
}
