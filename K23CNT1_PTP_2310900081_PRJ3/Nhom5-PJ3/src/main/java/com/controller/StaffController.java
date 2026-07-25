package com.controller;

import com.model.Staff;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public String listStaff(Model model) {

        model.addAttribute("staffList", staffService.getAllStaff());

        return "staff-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("staff", new Staff());

        return "staff-form";
    }

    @PostMapping("/save")
    public String saveStaff(@ModelAttribute Staff staff) {

        staffService.saveStaff(staff);

        return "redirect:/staff";
    }

    @GetMapping("/edit/{id}")
    public String editStaff(@PathVariable Long id, Model model) {

        model.addAttribute("staff", staffService.getStaffById(id));

        return "staff-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {

        staffService.deleteStaff(id);

        return "redirect:/staff";
    }

}