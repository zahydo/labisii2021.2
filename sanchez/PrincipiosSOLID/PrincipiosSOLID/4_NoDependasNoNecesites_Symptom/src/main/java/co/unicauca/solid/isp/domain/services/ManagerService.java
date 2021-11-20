
package co.unicauca.solid.isp.domain.services;

import co.unicauca.solid.isp.domain.IRepository;
import co.unicauca.solid.isp.domain.Project;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public class ManagerService {
        // El repositorio da acceso a todos los servicios, 
        // pero el manager sólo usa los de proyectos    
        private IRepository dataRepository;

        public ManagerService(IRepository repository)
        {
            dataRepository = repository;
        }

        public boolean CreateProject(Project project) {

            boolean result = true;

            /* business rules */
            dataRepository.createProject(project);

            return result;

        }

        public List<Project> GetProjects(int userId) {

            /* Validations and business rules */
            List<Project> projects = dataRepository.listProjectsByUser(userId);
            return projects;

        }
    
}
