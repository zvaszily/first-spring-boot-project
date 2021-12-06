package hu.nye.firstspringbootproject.dao;

import hu.nye.firstspringbootproject.domain.Role;
import hu.nye.firstspringbootproject.domain.User;
import hu.nye.firstspringbootproject.error.UserNotFoundException;
import hu.nye.firstspringbootproject.repository.RoleRepository;
import hu.nye.firstspringbootproject.repository.UserRepository;
import hu.nye.firstspringbootproject.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataAccessObject implements UserDataAccessObjectInterface, UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private final String USER_ROLE = "USER";
    @Autowired
    public UserDataAccessObject(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("User keresés");
        User user = findByEmail(username);
        if( user == null ){
            throw new UsernameNotFoundException(username);
        }

        return new UserDetailsImpl(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
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



    @Override
    public String registerUser(User userToRegister) {
        User userCheck = userRepository.findByEmail(userToRegister.getEmail());

        if (userCheck != null)
            return "alreadyExists";

        Role userRole = roleRepository.findByRole(USER_ROLE);
        if (userRole != null) {
            userToRegister.getRoles().add(userRole);
        } else {
            userToRegister.addRoles(USER_ROLE);
        }
        userRepository.save(userToRegister);

        return "ok";
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
