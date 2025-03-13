package com.hrms.controller.SelfService;

import com.hrms.model.SelfService.SupportTicket;
import com.hrms.service.SelfService.SupportTicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helpdesk")
public class SupportTicketController {

    private final SupportTicketService supportTicketService;

    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }


    @PostMapping("/ticket")
    public SupportTicket submitTicket(@RequestBody SupportTicket ticket) {
        return supportTicketService.submitTicket(ticket);
    }


    @GetMapping("/tickets")
    public List<SupportTicket> getAllTickets() {
        return supportTicketService.getAllTickets();
    }


    @GetMapping("/ticket/{id}")
    public SupportTicket getTicketById(@PathVariable Long id) {
        return supportTicketService.getTicketById(id);
    }


    @GetMapping("/tickets/user/{userId}")
    public List<SupportTicket> getTicketsByUserId(@PathVariable Long userId) {
        return supportTicketService.getTicketsByUserId(userId);
    }


    @PutMapping("/ticket/{id}")
    public SupportTicket updateTicket(@PathVariable Long id, @RequestBody SupportTicket updatedTicket) {
        return supportTicketService.updateTicket(id, updatedTicket);
    }


    @DeleteMapping("/ticket/{id}")
    public void deleteTicket(@PathVariable Long id) {
        supportTicketService.deleteTicket(id);
    }
}
