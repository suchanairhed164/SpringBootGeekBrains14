package com.example.demo.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @GetMapping("/index")
    public String doSmth() {
        return "index";
    }

    @GetMapping("/hello")
    public String  helloRequest(Model model, @RequestParam(value="name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/form")
    public String showForm(){
        return "simple-form";
    }

    @PostMapping("/form")
    public String saveForm(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
        System.out.println(name);
        System.out.println(email);
        return "redirect:/index";
    }

    @GetMapping("/addcat")
    public String showAddCatForm(Model model) {
        Cat cat = new Cat(1L, null, null);
        model.addAttribute("cat", cat);
        return "cat-form";
    }

    @PostMapping("/addcat")
    public String showAddCatForm(@ModelAttribute(value = "cat") Cat cat) {
        System.out.println(cat.getId() + " " + cat.getName() + " " + cat.getColor());
        return "redirect:/index";
    }
}


