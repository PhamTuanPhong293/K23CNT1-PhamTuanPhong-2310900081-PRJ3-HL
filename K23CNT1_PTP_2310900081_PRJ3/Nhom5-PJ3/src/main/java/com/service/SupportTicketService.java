package com.service;

import com.model.SupportTicket;

import java.util.List;

public interface SupportTicketService {

    // =========================
    // CRUD
    // =========================

    // Thêm Ticket
    SupportTicket createTicket(SupportTicket ticket);

    // Lấy tất cả Ticket
    List<SupportTicket> getAllTickets();

    // Tìm Ticket theo ID
    SupportTicket getTicketById(Long id);

    // Cập nhật Ticket
    SupportTicket updateTicket(SupportTicket ticket);

    // Xóa Ticket
    void deleteTicket(Long id);

    // =========================
    // Tìm kiếm
    // =========================

    // Theo trạng thái
    List<SupportTicket> getTicketsByStatus(String status);

    // Theo danh mục
    List<SupportTicket> getTicketsByCategory(String category);

    // Theo độ ưu tiên
    List<SupportTicket> getTicketsByPriority(String priority);

    // =========================
    // Dashboard
    // =========================

    // Đếm Ticket OPEN
    long countOpenTickets();

    // Đếm Ticket PROCESSING
    long countProcessingTickets();

    // Đếm Ticket CLOSED
    long countClosedTickets();

    // Lấy 5 Ticket mới nhất
    List<SupportTicket> getLatestTickets();

}