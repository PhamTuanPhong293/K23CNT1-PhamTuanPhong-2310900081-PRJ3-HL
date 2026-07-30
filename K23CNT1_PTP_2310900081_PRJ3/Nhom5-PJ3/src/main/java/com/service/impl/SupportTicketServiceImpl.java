package com.service.impl;

import com.model.SupportTicket;
import com.repository.SupportTicketRepository;
import com.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportTicketServiceImpl implements SupportTicketService {

    @Autowired
    private SupportTicketRepository ticketRepository;

    // =========================
    // CRUD
    // =========================

    @Override
    public SupportTicket createTicket(SupportTicket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<SupportTicket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public SupportTicket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public SupportTicket updateTicket(SupportTicket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    // =========================
    // Search
    // =========================

    @Override
    public List<SupportTicket> getTicketsByStatus(String status) {
        return ticketRepository.findByStatus(status);
    }

    @Override
    public List<SupportTicket> getTicketsByCategory(String category) {
        return ticketRepository.findByCategory(category);
    }

    @Override
    public List<SupportTicket> getTicketsByPriority(String priority) {
        return ticketRepository.findByPriority(priority);
    }

    // =========================
    // Dashboard
    // =========================

    @Override
    public long countOpenTickets() {
        return ticketRepository.countByStatus("OPEN");
    }

    @Override
    public long countProcessingTickets() {
        return ticketRepository.countByStatus("PROCESSING");
    }

    @Override
    public long countClosedTickets() {
        return ticketRepository.countByStatus("CLOSED");
    }

    @Override
    public List<SupportTicket> getLatestTickets() {
        return ticketRepository.findTop5ByOrderByIdDesc();
    }

}