package org.example.spring7homework2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/resource")
public class AuthorityController {
    @GetMapping("/auth/public-data/book")
    public String reader(Model model) {
        model.addAttribute("message", "This is a book");
        return "book";
    }

    @GetMapping("/auth/public-data")
    public String publicData(Model model) {
        model.addAttribute("message", "This is a public-data");
        return "publicData";
    }
}
