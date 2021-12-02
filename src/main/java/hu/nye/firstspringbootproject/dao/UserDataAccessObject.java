package hu.nye.firstspringbootproject.dao;

import hu.nye.firstspringbootproject.domain.Users;
import hu.nye.firstspringbootproject.error.UserNotFoundException;
import hu.nye.firstspringbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataAccessObject implements UserDataAccessObjectInterface{

    private UserRepository userRepository;

    @Autowired
    public UserDataAccessObject(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(Users user) {
        try {
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException("Something went wrong.");
        }
    }

    @Override
    public void deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Something went wrong.");
        }
    }
}
