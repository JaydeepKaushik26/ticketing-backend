package com.ticketing.backend.repository;

import com.ticketing.backend.entity.Ticket;
import com.ticketing.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCreatedBy(User user);
}
