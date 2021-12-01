package hu.nye.firstspringbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "Index";
    }

    @RequestMapping("/exams")
    public String exams(Model model){
        model.addAttribute("pageH1","Ez Egy új érték!");
        return "ExamsList";
    }
}
