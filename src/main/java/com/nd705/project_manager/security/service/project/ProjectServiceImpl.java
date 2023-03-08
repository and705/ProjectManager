package com.nd705.project_manager.security.service.project;

import com.nd705.project_manager.model.Project;
import com.nd705.project_manager.payload.request.NewProjectRequest;
import com.nd705.project_manager.repository.ProjectRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> getProjectsHierarchy() {
        List<Project> rootProjects = projectRepository.findAllRoots(); // first db call

        List<Long> rootCategoryIds = rootProjects.stream().map(Project::getId).collect(Collectors.toList());
        List<Project> subCategories = projectRepository.findAllSubCategoriesInRoot(rootCategoryIds); // second db call

        subCategories.forEach(subCategory -> {
            subCategory.getParentProject().getChildrens().add(subCategory); // no further db call, because everyone inside the root is in the persistence context.
        });

        return rootProjects;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project getProject(long id) {
        Project project = null;
        Optional<Project> prj = projectRepository.findById(id);
        if(prj.isPresent()){
            project = prj.get();
        }
        return project;
    }

    @Override
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project saveNewProject(NewProjectRequest newProjectRequest) {
        Project project = new Project();
        project.setParentProject(projectRepository.getReferenceById(newProjectRequest.getParentProjectId()));
        project.setRootProject(projectRepository.getReferenceById(newProjectRequest.getRootProjectId()));
        project.setTitle(newProjectRequest.getTitle());
        projectRepository.save(project);
        return project;
    }
}
