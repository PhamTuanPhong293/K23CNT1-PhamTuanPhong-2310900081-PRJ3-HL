package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.SupportTicket;
import com.repository.SupportTicketRepository;
import com.service.SupportTicketService;

@Service
public class SupportTicketServiceImpl implements SupportTicketService {

    @Autowired
    private SupportTicketRepository ticketRepository;

    @Override
    public List<SupportTicket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public SupportTicket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public SupportTicket saveTicket(SupportTicket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}