package com.controller;

import com.model.TicketReply;
import com.service.StaffService;
import com.service.SupportTicketService;
import com.service.TicketReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/replies")
public class TicketReplyController {

    @Autowired
    private TicketReplyService ticketReplyService;

    @Autowired
    private SupportTicketService ticketService;

    @Autowired
    private StaffService staffService;

    @GetMapping
    public String listReplies(Model model) {

        model.addAttribute("replyList", ticketReplyService.getAllReplies());

        return "reply-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("reply", new TicketReply());

        model.addAttribute("tickets", ticketService.getAllTickets());

        model.addAttribute("staffList", staffService.getAllStaff());

        return "reply-form";
    }

    @PostMapping("/save")
    public String saveReply(@ModelAttribute TicketReply reply) {

        ticketReplyService.saveReply(reply);

        return "redirect:/replies";
    }

    @GetMapping("/delete/{id}")
    public String deleteReply(@PathVariable Long id) {

        ticketReplyService.deleteReply(id);

        return "redirect:/replies";
    }
}