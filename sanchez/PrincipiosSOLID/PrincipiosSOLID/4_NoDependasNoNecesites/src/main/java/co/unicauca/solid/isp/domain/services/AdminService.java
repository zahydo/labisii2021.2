package co.unicauca.solid.isp.domain.services;

import co.unicauca.solid.isp.domain.IUserRepository;
import co.unicauca.solid.isp.domain.User;
import java.util.List;

/**
 *
 * @author Libardo
 */
public class AdminService {

    private IUserRepository dataRepository;

    public AdminService(IUserRepository repository) {
        dataRepository = repository;
    }

    public boolean saveUser(User user) {

        boolean result = true;

        /* business rules */
        dataRepository.createUser(user);

        return result;
    }

    public List<User> getUsers() {

        /* Validations and business rules */
        List<User> users = dataRepository.listUsers();
        return users;

    }

    public boolean deleteUser(User user) {

        boolean result = true;

        /* Validations and business rules */
        dataRepository.deleteUser(user);

        return result;
    }

}
