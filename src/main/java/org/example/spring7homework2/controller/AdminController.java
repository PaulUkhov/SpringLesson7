package org.example.spring7homework2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/resource")
public class AdminController {
    @GetMapping("/admin/issue/private-data")
    public String PrivateData(Model model) {
        model.addAttribute("message", "This is a private-data");
        return "privateData";
    }
    @GetMapping("/admin/issue")
    public String issue(Model model) {
        model.addAttribute("message", "This is a issue");
        return "issue";
    }
}
