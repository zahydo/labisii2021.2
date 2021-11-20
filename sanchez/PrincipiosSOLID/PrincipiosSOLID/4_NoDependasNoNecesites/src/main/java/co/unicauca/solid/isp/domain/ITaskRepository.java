package co.unicauca.solid.isp.domain;

import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public interface ITaskRepository {

    //Task methods
    void createTask(Task task);

    List<Task> listCompletedTasksByUser(int userId);

    void deleteTask(Task task);
}
