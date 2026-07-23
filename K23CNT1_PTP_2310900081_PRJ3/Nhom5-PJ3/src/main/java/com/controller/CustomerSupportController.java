package com.controller;

import com.model.SupportTicket;
import com.service.CustomerService;
import com.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerSupportController {

    @Autowired
    private SupportTicketService ticketService;

    @Autowired
    private CustomerService customerService;

    // Trang chủ
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Danh sách Ticket
    @GetMapping("/tickets")
    public String listTickets(Model model) {

        model.addAttribute("tickets", ticketService.getAllTickets());

        return "ticket-list";
    }

    // Hiển thị form thêm Ticket
    @GetMapping("/tickets/new")
    public String showCreateForm(Model model) {

        model.addAttribute("ticket", new SupportTicket());

        model.addAttribute("customers", customerService.getAllCustomers());

        return "ticket-form";
    }

    // Lưu Ticket
    @PostMapping("/tickets/save")
    public String saveTicket(@ModelAttribute("ticket") SupportTicket ticket) {

        ticketService.saveTicket(ticket);

        return "redirect:/tickets";
    }

    // Hiển thị form sửa
    @GetMapping("/tickets/edit/{id}")
    public String editTicket(@PathVariable Long id, Model model) {

        model.addAttribute("ticket", ticketService.getTicketById(id));

        model.addAttribute("customers", customerService.getAllCustomers());

        return "ticket-form";
    }

    // Xóa Ticket
    @GetMapping("/tickets/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicket(id);

        return "redirect:/tickets";
    }

}