package com.service.impl;

import com.model.FAQ;
import com.repository.FAQRepository;
import com.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    private FAQRepository faqRepository;

    @Override
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }

    @Override
    public FAQ getFAQById(Long id) {
        return faqRepository.findById(id).orElse(null);
    }

    @Override
    public FAQ saveFAQ(FAQ faq) {
        return faqRepository.save(faq);
    }

    @Override
    public void deleteFAQ(Long id) {
        faqRepository.deleteById(id);
    }
}