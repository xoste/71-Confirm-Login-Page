package com.xoste.leon.controller;

import com.xoste.leon.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Leon
 */
@Controller
public class DispatcherController {
    @RequestMapping("{jsp}")
    public String main(@PathVariable String jsp) {
        System.out.println("restful");
        return jsp;
    }

    @RequestMapping("/login")
    public String login(Users users, HttpSession session) {
        System.out.println("login");
        System.out.println("users..." + users);
        if ("admin".equals(users.getUsername()) && "123".equals(users.getPassword())) {
            session.setAttribute("users", users);
            return "main";
        } else {
            return "redirect:/login.jsp";
        }
    }
}
