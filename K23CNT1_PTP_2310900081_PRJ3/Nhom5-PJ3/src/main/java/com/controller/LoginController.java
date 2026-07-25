package com.controller;

import com.model.User;
import com.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(HttpSession session, Model model) {

        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/";
        }

        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user,
                        HttpSession session,
                        Model model) {

        User loginUser =
                userService.login(user.getUsername(), user.getPassword());

        if (loginUser != null) {

            session.setAttribute("loggedUser", loginUser);

            return "redirect:/";
        }

        model.addAttribute("user", new User());
        model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

}