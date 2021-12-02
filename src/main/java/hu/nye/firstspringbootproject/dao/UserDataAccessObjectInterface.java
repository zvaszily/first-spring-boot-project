package hu.nye.firstspringbootproject.dao;

import hu.nye.firstspringbootproject.domain.Users;

import java.util.List;

public interface UserDataAccessObjectInterface {

    Users getUserById(Long id);

    List<Users> getAllUser();

    void addUser(Users user);

    void deleteUserById(Long id);
}
