package com.nd705.project_manager.security.service.project;

import com.nd705.project_manager.model.Project;
import com.nd705.project_manager.payload.request.NewProjectRequest;

import java.util.List;

public interface ProjectService {
    public List<Project> getProjectsHierarchy();
    public List<Project> getAllProjects();
    public void saveProject(Project project);
    public Project saveNewProject(NewProjectRequest newProjectRequest);
    public Project getProject(long id);
    public void deleteProject(long id);

}
