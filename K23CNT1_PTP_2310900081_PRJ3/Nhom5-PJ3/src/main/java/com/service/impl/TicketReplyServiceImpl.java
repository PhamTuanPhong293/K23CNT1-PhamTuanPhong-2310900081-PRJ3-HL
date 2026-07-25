package com.service.impl;

import com.model.TicketReply;
import com.repository.TicketReplyRepository;
import com.service.TicketReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketReplyServiceImpl implements TicketReplyService {

    @Autowired
    private TicketReplyRepository ticketReplyRepository;

    @Override
    public List<TicketReply> getAllReplies() {
        return ticketReplyRepository.findAll();
    }

    @Override
    public TicketReply getReplyById(Long id) {
        return ticketReplyRepository.findById(id).orElse(null);
    }

    @Override
    public TicketReply saveReply(TicketReply reply) {
        return ticketReplyRepository.save(reply);
    }

    @Override
    public void deleteReply(Long id) {
        ticketReplyRepository.deleteById(id);
    }
}