package com.controller;

import com.model.FAQ;
import com.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faq")
public class FAQController {

    @Autowired
    private FAQService faqService;

    @GetMapping
    public String listFAQ(Model model) {

        model.addAttribute("faqList", faqService.getAllFAQs());

        return "faq-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("faq", new FAQ());

        return "faq-form";
    }

    @PostMapping("/save")
    public String saveFAQ(@ModelAttribute FAQ faq) {

        faqService.saveFAQ(faq);

        return "redirect:/faq";
    }

    @GetMapping("/edit/{id}")
    public String editFAQ(@PathVariable Long id, Model model) {

        model.addAttribute("faq", faqService.getFAQById(id));

        return "faq-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteFAQ(@PathVariable Long id) {

        faqService.deleteFAQ(id);

        return "redirect:/faq";
    }
}