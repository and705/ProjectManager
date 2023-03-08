package com.nd705.project_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "task_name")
    String taskName;
    @Column(name = "task_type")
    String taskType;
    @Column(name = "task_status")
    String taskStatus;
    @Column(name = "task_date_of_create")
    LocalDateTime taskDateOfCreate;
    @Column(name = "task_date_of_status_change")
    LocalDateTime taskDateOfStatusChange;
    @Column(name = "task_info")
    String taskInfo;

    @Column(name = "task_owner")
    String taskOwner;
    @Column(name = "task_editor")
    String taskEditor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;

    public Task() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDateTime getTaskDateOfCreate() {
        return taskDateOfCreate;
    }

    public void setTaskDateOfCreate(LocalDateTime taskDateOfCreate) {
        this.taskDateOfCreate = taskDateOfCreate;
    }

    public LocalDateTime getTaskDateOfStatusChange() {
        return taskDateOfStatusChange;
    }

    public void setTaskDateOfStatusChange(LocalDateTime taskDateOfStatusChange) {
        this.taskDateOfStatusChange = taskDateOfStatusChange;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(String taskOwner) {
        this.taskOwner = taskOwner;
    }

    public String getTaskEditor() {
        return taskEditor;
    }

    public void setTaskEditor(String taskEditor) {
        this.taskEditor = taskEditor;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
