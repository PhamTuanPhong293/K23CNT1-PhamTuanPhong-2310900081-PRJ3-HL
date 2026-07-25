package com.repository;

import com.model.TicketReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketReplyRepository extends JpaRepository<TicketReply, Long> {

}