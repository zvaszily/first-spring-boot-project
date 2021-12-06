package hu.nye.firstspringbootproject.controller;

import hu.nye.firstspringbootproject.dao.UserDataAccessObjectInterface;
import hu.nye.firstspringbootproject.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final String ROOT_MAPPING = "/";
    private static final String USERS_PAGE_MAPPING = "/users";
    private static final String USERS_MODEL_KEY = "userList";

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private UserDataAccessObjectInterface userData;

    @Autowired
    public HomeController(UserDataAccessObjectInterface userData) {
        this.userData = userData;
    }

    @RequestMapping(ROOT_MAPPING)
    public String index(){
        return "Index";
    }

    @RequestMapping("/exams")
    public String exams(Model model){
        return "ExamsList";
    }

    @RequestMapping(USERS_PAGE_MAPPING)
    public String userList(Model model){
        model.addAttribute(USERS_MODEL_KEY,userData.getAllUser());
        return "UserList";
    }

    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user) {
        log.info("Uj user!");
        System.out.println(user.getFullName());
        System.out.println(user.getPassword());
        System.out.println(user);
        log.debug(user.getFullName());
        log.debug(user.getPassword());
        userData.registerUser(user);
        return "auth/login";
    }

}
