package com.nd705.project_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_project_id")
    @JsonIgnore
    public Project parentProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "root_project_id")
    @JsonIgnore
    public Project rootProject;

    @Transient
    public List<Project> childrens = new ArrayList<Project>();




    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Project getParentProject() {
        return parentProject;
    }

    public void setParentProject(Project parentProject) {
        this.parentProject = parentProject;
    }

    public Project getRootProject() {
        return rootProject;
    }

    public void setRootProject(Project rootProject) {
        this.rootProject = rootProject;
    }

    public List<Project> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Project> childrens) {
        this.childrens = childrens;
    }
}
