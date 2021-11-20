package co.unicauca.solid.isp.domain;


/**
 *
 * @author Libardo
 */
public class Task {

    private int taskId;
    private String name;
    private int estimationPoints;
    private boolean Ddne;

    public Task(int taskId, String name, int estimationPoints, boolean Ddne) {
        this.taskId = taskId;
        this.name = name;
        this.estimationPoints = estimationPoints;
        this.Ddne = Ddne;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimationPoints() {
        return estimationPoints;
    }

    public void setEstimationPoints(int estimationPoints) {
        this.estimationPoints = estimationPoints;
    }

    public boolean isDdne() {
        return Ddne;
    }

    public void setDdne(boolean Ddne) {
        this.Ddne = Ddne;
    }

}
