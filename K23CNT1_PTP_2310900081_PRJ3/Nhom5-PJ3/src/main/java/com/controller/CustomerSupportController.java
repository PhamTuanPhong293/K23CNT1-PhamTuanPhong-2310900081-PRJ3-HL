package com.controller;

import com.model.Customer;
import com.model.SupportTicket;
import com.service.CustomerService;
import com.service.FAQService;
import com.service.StaffService;
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

    @Autowired
    private StaffService staffService;

    @Autowired
    private FAQService faqService;

    // =========================
    // Dashboard
    // =========================
    @GetMapping("/")
    public String home(Model model) {

        long customerCount = customerService.getAllCustomers().size();
        long ticketCount = ticketService.getAllTickets().size();
        long staffCount = staffService.getAllStaff().size();
        long faqCount = faqService.getAllFAQs().size();

        long openCount = ticketService.countOpenTickets();
        long processingCount = ticketService.countProcessingTickets();
        long closedCount = ticketService.countClosedTickets();

        double openPercent = 0;
        double processingPercent = 0;
        double closedPercent = 0;

        if (ticketCount > 0) {
            openPercent = (openCount * 100.0) / ticketCount;
            processingPercent = (processingCount * 100.0) / ticketCount;
            closedPercent = (closedCount * 100.0) / ticketCount;
        }

        model.addAttribute("customerCount", customerCount);
        model.addAttribute("ticketCount", ticketCount);
        model.addAttribute("staffCount", staffCount);
        model.addAttribute("faqCount", faqCount);

        model.addAttribute("openCount", openCount);
        model.addAttribute("processingCount", processingCount);
        model.addAttribute("closedCount", closedCount);

        model.addAttribute("openPercent", openPercent);
        model.addAttribute("processingPercent", processingPercent);
        model.addAttribute("closedPercent", closedPercent);

        // 5 Ticket mới nhất
        model.addAttribute("latestTickets", ticketService.getLatestTickets());

        return "index";
    }

    // =========================
    // Danh sách Ticket
    // =========================
    @GetMapping("/tickets")
    public String listTickets(Model model) {

        model.addAttribute("tickets", ticketService.getAllTickets());

        return "ticket-list";
    }

    // =========================
    // Form thêm Ticket
    // =========================
    @GetMapping("/tickets/new")
    public String showCreateForm(Model model) {

        model.addAttribute("ticket", new SupportTicket());
        model.addAttribute("customers", customerService.getAllCustomers());

        return "ticket-form";
    }

    // =========================
    // Lưu Ticket
    // =========================
    @PostMapping("/tickets/save")
    public String saveTicket(@ModelAttribute("ticket") SupportTicket ticket,
                             @RequestParam("customerId") Long customerId) {

        Customer customer = customerService.getCustomerById(customerId);

        ticket.setCustomer(customer);

        ticketService.createTicket(ticket);

        return "redirect:/tickets";
    }

    // =========================
    // Form sửa Ticket
    // =========================
    @GetMapping("/tickets/edit/{id}")
    public String editTicket(@PathVariable Long id, Model model) {

        model.addAttribute("ticket", ticketService.getTicketById(id));
        model.addAttribute("customers", customerService.getAllCustomers());

        return "ticket-form";
    }

    // =========================
    // Xóa Ticket
    // =========================
    @GetMapping("/tickets/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicket(id);

        return "redirect:/tickets";
    }

}