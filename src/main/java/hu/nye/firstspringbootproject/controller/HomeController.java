package hu.nye.firstspringbootproject.controller;

import hu.nye.firstspringbootproject.dao.UserDataAccessObjectInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final String ROOT_MAPPING = "/";
    private static final String USERS_PAGE_MAPPING = "/users";
    private static final String USERS_MODEL_KEY = "userList";

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
        model.addAttribute("pageH1","Ez Egy új érték!");
        return "ExamsList";
    }

    @RequestMapping(USERS_PAGE_MAPPING)
    public String userList(Model model){
        model.addAttribute(USERS_MODEL_KEY,userData.getAllUser());
        return "UserList";
    }

}
