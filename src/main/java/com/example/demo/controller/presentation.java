package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class presentation {

    @RequestMapping("/index")
    public Object index() {
        return "/index";
    }

    @RequestMapping("/about")
    public Object about() {
        return "/about";
    }

    @RequestMapping("/detail")
    public Object detail() {
        return "/detail";
    }

    @RequestMapping("/iframe")
    public Object iframe() {
        return "/iframe";
    }

    @RequestMapping("/list")
    public Object list() {
        return "/list";
    }

    @RequestMapping("/login")
    public Object login() {
        return "/login";
    }

    @RequestMapping("/user")
    public Object user() {
        return "/user";
    }

    @RequestMapping("/useradd")
    public Object useradd() {
        return "/useradd";
    }

    @RequestMapping("/usercol")
    public Object usercol() {
        return "/usercol";
    }

    @RequestMapping("/usershop")
    public Object usershop() {
        return "/usershop";
    }
}
