package com.hrms.controller.SelfService;

import com.hrms.model.SelfService.SupportTicket;
import com.hrms.service.SelfService.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:3000")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;


    @RequestMapping(value = "/{id}/status", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getTicketById(@PathVariable Long id) {
        SupportTicket ticket = supportTicketService.getTicketById(id);
        return (ticket != null) ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }


    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<SupportTicket>> getTicketsByEmployeeId(@PathVariable Long employeeId) {
        List<SupportTicket> tickets = supportTicketService.getTicketsByEmployeeId(employeeId);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }


    @PostMapping
    public ResponseEntity<SupportTicket> createTicket(@RequestBody SupportTicket ticket) {
        return ResponseEntity.ok(supportTicketService.createTicket(ticket));
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<SupportTicket> updateTicketStatus(
            @PathVariable Long id,
            @RequestParam(value = "status", required = false, defaultValue = "Pending") String status) {

        SupportTicket updatedTicket = supportTicketService.updateTicketStatus(id, status);
        return updatedTicket != null ? ResponseEntity.ok(updatedTicket) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        return supportTicketService.deleteTicket(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
