package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.Customer;
import com.service.CustomerService;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Hiển thị danh sách khách hàng
    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();

        // DEBUG: Kiểm tra encoding
        System.out.println("========== DEBUG ENCODING ==========");
        for (Customer c : customers) {
            System.out.println("ID: " + c.getId());
            System.out.println("FullName: " + c.getFullName());
            System.out.println("FullName Bytes: " + java.util.Arrays.toString(c.getFullName().getBytes(StandardCharsets.UTF_8)));
            System.out.println("Email: " + c.getEmail());
            System.out.println("-----------------------------------");
        }
        System.out.println("=====================================");

        model.addAttribute("customers", customers);
        return "customer-list";
    }

    // Hiển thị form thêm khách hàng
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    // Lưu khách hàng
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        System.out.println("Saving customer: " + customer.getFullName());
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer-form";
    }

    // Xóa khách hàng
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}