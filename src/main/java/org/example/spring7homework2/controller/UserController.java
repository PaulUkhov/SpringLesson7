package org.example.spring7homework2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/resource")
public class UserController {
    @GetMapping("/user/reader")
    public String reader(Model model) {
        model.addAttribute("message", "This is a reader");
        return "reader";
    }

}
