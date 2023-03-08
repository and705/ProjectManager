package com.nd705.project_manager.payload.request;

public class NewProjectRequest {
    private String title;
    private long parentProjectId;

    private long rootProjectId;

    public NewProjectRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getParentProjectId() {
        return parentProjectId;
    }

    public void setParentProjectId(long parentProjectId) {
        this.parentProjectId = parentProjectId;
    }

    public long getRootProjectId() {
        return rootProjectId;
    }

    public void setRootProjectId(long rootProjectId) {
        this.rootProjectId = rootProjectId;
    }
}
