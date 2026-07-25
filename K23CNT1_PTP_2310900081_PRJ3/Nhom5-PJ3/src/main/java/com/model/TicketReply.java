package com.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_replies")
public class TicketReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(MAX)", nullable = false)
    private String replyContent;

    private LocalDateTime replyDate;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private SupportTicket ticket;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public TicketReply() {
        this.replyDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public LocalDateTime getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDateTime replyDate) {
        this.replyDate = replyDate;
    }

    public SupportTicket getTicket() {
        return ticket;
    }

    public void setTicket(SupportTicket ticket) {
        this.ticket = ticket;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}