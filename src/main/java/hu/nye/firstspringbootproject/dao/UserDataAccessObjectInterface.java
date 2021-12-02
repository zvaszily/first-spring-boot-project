package hu.nye.firstspringbootproject.dao;

import hu.nye.firstspringbootproject.domain.Users;

import java.util.Collection;

public interface UserDataAccessObjectInterface {

    Users getUserById(Long id);

    Collection<Users> getAllUser();

    void addUser(Users user);

    void deleteUserById(Long id);
}
