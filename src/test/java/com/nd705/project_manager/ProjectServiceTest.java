package com.nd705.project_manager;

import com.nd705.project_manager.model.Project;
import com.nd705.project_manager.repository.ProjectRepository;
import com.nd705.project_manager.service.project.ProjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest {
    @InjectMocks
    private ProjectServiceImpl projectService;

    @Mock
    private ProjectRepository projectRepository;



    @Test
    public void getAllProjectsTest(){
        List<Project> allProjects = projectService.getAllProjects();
        assertNotNull(allProjects);
    }
    @Test
    public void getProjectsHierarchyTest() {
        List<Project> rootProjects = projectRepository.findAllRoots();

        List<Long> rootCategoryIds = rootProjects.stream().map(Project::getId).collect(Collectors.toList());
        List<Project> subCategories = projectRepository.findAllSubCategoriesInRoot(rootCategoryIds);

        subCategories.forEach(subCategory -> {
            subCategory.getParentProject().getChildrens().add(subCategory);
        });
        assertNotNull(rootProjects);

    }
    @Test
    public void getProjectTest() {
        long prjId = 1;
        when(projectRepository.findById(prjId)).thenReturn(Optional.of(new Project()));
        Project project = null;
        Optional<Project> prj = projectRepository.findById(prjId);
        if(prj.isPresent()){
            project = prj.get();
        }
        assertNotNull(project);
    }
}


