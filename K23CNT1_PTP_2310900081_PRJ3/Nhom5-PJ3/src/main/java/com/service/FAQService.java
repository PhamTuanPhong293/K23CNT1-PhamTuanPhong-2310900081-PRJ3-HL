package com.service;

import com.model.FAQ;

import java.util.List;

public interface FAQService {

    List<FAQ> getAllFAQs();

    FAQ getFAQById(Long id);

    FAQ saveFAQ(FAQ faq);

    void deleteFAQ(Long id);

}