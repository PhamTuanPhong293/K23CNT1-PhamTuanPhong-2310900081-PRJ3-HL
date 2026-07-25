package com.repository;

import com.model.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {

    // Tìm theo trạng thái
    List<SupportTicket> findByStatus(String status);

    // Tìm theo danh mục
    List<SupportTicket> findByCategory(String category);

    // Tìm theo độ ưu tiên
    List<SupportTicket> findByPriority(String priority);

}