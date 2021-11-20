
package co.unicauca.solid.isp.domain.services;



import co.unicauca.solid.isp.domain.IProjectRepository;
import co.unicauca.solid.isp.domain.Project;
import java.util.List;

/**
 *
 * @author Libardo
 */
public class ManagerService {
        private IProjectRepository dataRepository;

        public ManagerService(IProjectRepository repository)
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
