package co.unicauca.solid.isp.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Libardo
 */
public class Project {

    private int projectId;
    private String name;
    private LocalDateTime startDate;

    public Project(int projectId, String name, LocalDateTime startDate) {
        this.projectId = projectId;
        this.name = name;
        this.startDate = startDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

}
