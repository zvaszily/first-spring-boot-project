package hu.nye.firstspringbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "Index";
    }

    @RequestMapping("/exams")
    public String exams(){
        return "ExamsList";
    }
}
