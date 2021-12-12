package hu.nye.firstspringbootproject.controller;

import hu.nye.firstspringbootproject.dao.UserDataAccessObjectInterface;
import hu.nye.firstspringbootproject.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static final String GET_ALL_USER_MAPPING = "/user/users";

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private UserDataAccessObjectInterface userData;

    @Autowired
    public UserController(UserDataAccessObjectInterface userData) {
        this.userData = userData;
    }

    @GetMapping(path = GET_ALL_USER_MAPPING)
    public List<User> getAllUser() {
        return userData.getAllUser();
    }
}
