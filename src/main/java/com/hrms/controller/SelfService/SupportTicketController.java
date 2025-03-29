package com.hrms.controller.SelfService;


import com.hrms.model.SelfService.SupportTicket;

import com.hrms.service.SelfService.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supporttickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;


    @GetMapping
    public List<SupportTicket> getAllTickets() {
        return supportTicketService.getAllTickets();
    }


    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getTicketById(@PathVariable Long id) {
        SupportTicket ticket = supportTicketService.getTicketById(id);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }


    @GetMapping("/employee/{employeeId}")
    public List<SupportTicket> getTicketsByEmployeeId(@PathVariable Long employeeId) {
        return supportTicketService.getTicketsByEmployeeId(employeeId);
    }


    @PostMapping
    public ResponseEntity<SupportTicket> createTicket(@RequestBody SupportTicket ticket) {
        return ResponseEntity.ok(supportTicketService.createTicket(ticket));
    }


    @PutMapping("/{id}")
    public ResponseEntity<SupportTicket> updateTicket(@PathVariable Long id, @RequestBody SupportTicket ticket) {
        SupportTicket updatedTicket = supportTicketService.updateTicket(id, ticket);
        return updatedTicket != null ? ResponseEntity.ok(updatedTicket) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        return supportTicketService.deleteTicket(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
