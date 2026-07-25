package com.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "support_tickets")
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tiêu đề ticket
    private String title;

    // Nội dung hỗ trợ
    @Column(length = 2000)
    private String description;

    // Trạng thái
    private String status;

    // Danh mục
    private String category;

    // Độ ưu tiên
    private String priority;

    // Nhân viên phụ trách
    @Column(name = "assigned_to")
    private String assignedTo;

    // Thời gian tạo
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Thời gian cập nhật
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Khách hàng gửi ticket
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public SupportTicket() {
        this.status = "OPEN";
        this.priority = "Trung bình";
        this.createdAt = LocalDateTime.now();
    }

    //========================
    // Getter & Setter
    //========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}