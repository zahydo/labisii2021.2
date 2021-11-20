package co.unicauca.solid.isp.domain;

import java.util.List;

/**
 *
 * @author Libardo
 */
public interface IUserRepository {
    //User methods

    void createUser(User user);

    List<User> listUsers();

    void deleteUser(User user);

}
