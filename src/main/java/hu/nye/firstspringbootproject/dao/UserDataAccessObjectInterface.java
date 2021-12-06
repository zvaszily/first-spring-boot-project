package hu.nye.firstspringbootproject.dao;

import hu.nye.firstspringbootproject.domain.Role;
import hu.nye.firstspringbootproject.domain.User;

import java.util.List;

public interface UserDataAccessObjectInterface {

    User getUserById(Long id);

    List<User> getAllUser();

    public User findByEmail(String email);

    String registerUser(User user);

    Role findByRole(String role);

    void addUser(User user);

    void deleteUserById(Long id);
}
