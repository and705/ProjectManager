package com.nd705.project_manager.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "task_name")
    String taskName;
    @Column(name = "task_type")
    String taskType;
    @Column(name = "task_status")
    String taskStatus;
    @Column(name = "task_date_of_create")
    Date taskDateOfCreate;
    @Column(name = "task_date_of_status_change")
    Date taskDateOfStatusChange;
    @Column(name = "task_info")
    String taskInfo;
    @Column(name = "task_owner")
    String taskOwner;
    @Column(name = "task_editor")
    String taskEditor;

    public Task() {
    }

    public Task(String taskName, String taskType, String taskStatus, String taskInfo, String taskOwner) {
        this.taskName = taskName;
        this.taskType = taskType;
        this.taskStatus = taskStatus;
        this.taskInfo = taskInfo;
        this.taskOwner = taskOwner;
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

    public Date getTaskDateOfCreate() {
        return taskDateOfCreate;
    }

    public void setTaskDateOfCreate(Date taskDateOfCreate) {
        this.taskDateOfCreate = taskDateOfCreate;
    }

    public Date getTaskDateOfStatusChange() {
        return taskDateOfStatusChange;
    }

    public void setTaskDateOfStatusChange(Date taskDateOfStatusChange) {
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskDateOfCreate=" + taskDateOfCreate +
                ", taskDateOfStatusChange=" + taskDateOfStatusChange +
                ", taskInfo='" + taskInfo + '\'' +
                ", taskOwner='" + taskOwner + '\'' +
                ", taskEditor='" + taskEditor + '\'' +
                '}';
    }
}
