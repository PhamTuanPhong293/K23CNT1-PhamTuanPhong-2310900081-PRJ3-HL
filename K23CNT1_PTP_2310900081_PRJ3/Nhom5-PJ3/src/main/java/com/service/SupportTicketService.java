package com.service;

import java.util.List;

import com.model.SupportTicket;

public interface SupportTicketService {

    // Lấy danh sách tất cả phiếu hỗ trợ
    List<SupportTicket> getAllTickets();

    // Lấy phiếu hỗ trợ theo ID
    SupportTicket getTicketById(Long id);

    // Thêm hoặc cập nhật phiếu hỗ trợ
    SupportTicket saveTicket(SupportTicket ticket);

    // Xóa phiếu hỗ trợ
    void deleteTicket(Long id);

}