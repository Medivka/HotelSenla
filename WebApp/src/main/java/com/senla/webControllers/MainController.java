package com.senla.webControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String AboutMe() {
        return "Hello";
    }

    @GetMapping("/index")
    public String returnIndex() {
        return "index";
    }

    @GetMapping("/rest")
    public String returnRest() {
        return "rest";
    }

    @GetMapping("/me")
    public String returnMe() {
        return "me";
    }
    @GetMapping("/contact")
    public String myContact(){
        return "contact";
    }

}
