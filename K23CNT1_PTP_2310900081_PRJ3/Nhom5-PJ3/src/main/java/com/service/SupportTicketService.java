package com.service;

import com.model.SupportTicket;

import java.util.List;

public interface SupportTicketService {

    // Thêm Ticket
    SupportTicket createTicket(SupportTicket ticket);

    // Lấy tất cả Ticket
    List<SupportTicket> getAllTickets();

    // Tìm theo ID
    SupportTicket getTicketById(Long id);

    // Cập nhật Ticket
    SupportTicket updateTicket(SupportTicket ticket);

    // Xóa Ticket
    void deleteTicket(Long id);

    // Tìm theo trạng thái
    List<SupportTicket> getTicketsByStatus(String status);

    // Tìm theo danh mục
    List<SupportTicket> getTicketsByCategory(String category);

    // Tìm theo độ ưu tiên
    List<SupportTicket> getTicketsByPriority(String priority);

}