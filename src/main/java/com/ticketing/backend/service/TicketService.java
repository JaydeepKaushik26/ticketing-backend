package com.ticketing.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ticketing.backend.entity.Ticket;
import com.ticketing.backend.entity.User;
import com.ticketing.backend.enums.Priority;
import com.ticketing.backend.enums.TicketStatus;
import com.ticketing.backend.repository.TicketRepository;
import com.ticketing.backend.repository.UserRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public Ticket createTicket(Long userId, String subject, String description, Priority priority) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Ticket ticket = new Ticket();
        ticket.setSubject(subject);
        ticket.setDescription(description);
        ticket.setPriority(priority);
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setCreatedBy(user);

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ticketRepository.findByCreatedBy(user);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket updateTicketStatus(Long ticketId, TicketStatus status) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
    // USER: RATE TICKET

    public Ticket rateTicket(Long ticketId, Integer rating, String feedback) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (rating < 1 || rating > 5) {
            throw new RuntimeException("Rating must be between 1 and 5");
        }

        ticket.setRating(rating);
        ticket.setFeedback(feedback);

        return ticketRepository.save(ticket);
    }

}
