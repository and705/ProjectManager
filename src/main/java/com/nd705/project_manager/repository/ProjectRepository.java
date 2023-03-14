package com.nd705.project_manager.repository;

import com.nd705.project_manager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Query("SELECT project FROM Project project "
            + " WHERE project.parentProject.id IS NULL")
    List<Project> findAllRoots();

    @Query("SELECT project FROM Project project"
            + " WHERE project.rootProject.id IN :rootIds ")
    List<Project> findAllSubCategoriesInRoot(@Param("rootIds") List<Long> rootIds);


}
