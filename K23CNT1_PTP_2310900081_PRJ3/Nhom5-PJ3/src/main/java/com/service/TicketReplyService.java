package com.service;

import com.model.TicketReply;

import java.util.List;

public interface TicketReplyService {

    List<TicketReply> getAllReplies();

    TicketReply getReplyById(Long id);

    TicketReply saveReply(TicketReply reply);

    void deleteReply(Long id);

}