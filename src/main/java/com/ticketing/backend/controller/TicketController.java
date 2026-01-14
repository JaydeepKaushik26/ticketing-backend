package com.ticketing.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketing.backend.entity.Ticket;
import com.ticketing.backend.enums.Priority;
import com.ticketing.backend.enums.TicketStatus;
import com.ticketing.backend.service.TicketService;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(
            @RequestParam Long userId,
            @RequestParam String subject,
            @RequestParam String description,
            @RequestParam Priority priority
    ) {
        return ticketService.createTicket(userId, subject, description, priority);
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getUserTickets(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicketById(@PathVariable Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @GetMapping("/admin")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PutMapping("/{ticketId}/status")
    public Ticket updateTicketStatus(
            @PathVariable Long ticketId,
            @RequestParam TicketStatus status
    ) {
        return ticketService.updateTicketStatus(ticketId, status);
    }
    // USER: RATE TICKET

    @PostMapping("/{ticketId}/rate")
    public Ticket rateTicket(
            @PathVariable Long ticketId,
            @RequestParam Integer rating,
            @RequestParam(required = false) String feedback
    ) {
        return ticketService.rateTicket(ticketId, rating, feedback);
    }

}
