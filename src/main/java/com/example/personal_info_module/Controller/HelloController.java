package com.example.personal_info_module.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

//    @GetMapping("/hello")
//    public String hello(
//    		Model model
//    		) {
//        model.addAttribute("message", "Hello Thymeleaf!!");
//        return "hello";
//    }
    
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("modelValue", "Model Value!!");
        return "hello";
    }
}
