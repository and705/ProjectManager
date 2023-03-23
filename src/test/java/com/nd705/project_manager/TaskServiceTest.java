package com.nd705.project_manager;

import com.nd705.project_manager.model.Project;
import com.nd705.project_manager.model.Task;
import com.nd705.project_manager.repository.ProjectRepository;
import com.nd705.project_manager.repository.TaskRepository;
import com.nd705.project_manager.service.project.ProjectServiceImpl;
import com.nd705.project_manager.service.project.TaskServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
    @InjectMocks
    private TaskServiceImpl taskService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllProjectsTest(){
        Iterable<Task> allTasks = taskService.getAllTasks();
        assertNotNull(allTasks);
    }

    @Test
    public void getTaskTest() {
        long id = 1;
        when(taskRepository.findById(id)).thenReturn(Optional.of(new Task()));
        Task task = taskService.getTask(id);
        assertNotNull(task);
    }


}
