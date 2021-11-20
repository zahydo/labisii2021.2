package co.unicauca.solid.isp.domain;

import java.util.List;

/**
 * Interfaz de proyectos
 *
 * @author Libardo, Julio
 */
public interface IProjectRepository {

    //Project methods
    void createProject(Project project);

    List<Project> listProjectsByUser(int userId);

}
