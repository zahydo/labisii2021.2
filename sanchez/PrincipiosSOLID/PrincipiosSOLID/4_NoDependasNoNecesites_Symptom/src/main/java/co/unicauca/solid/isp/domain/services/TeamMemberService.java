
package co.unicauca.solid.isp.domain.services;

import co.unicauca.solid.isp.domain.IRepository;
import co.unicauca.solid.isp.domain.Task;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public class TeamMemberService {
        // El repositorio da acceso a todos los servicios, 
        // pero el equipo sólo usa los de tareas
        private IRepository dataRepository;

        public TeamMemberService(IRepository repository)
        {
            dataRepository = repository;
        }

        public boolean SaveTask(Task task)
        {

            boolean result = true;

            /* business rules */
            dataRepository.createTask(task);

            return result;
        }

        public List<Task> GetCompletedTasks(int userId)
        {

            /* Validations and business rules */

            List<Task> tasks = dataRepository.listCompletedTasksByUser(userId);
            return tasks;

        }

        public boolean DeleteTask(Task task)
        {

            boolean result = true;

            /* Validations and business rules */
            dataRepository.deleteTask(task);

            return result;
        }    
}
