package com.hrms.service.SelfService;



import com.hrms.model.SelfService.SupportTicket;

import com.hrms.repository.Selfservice.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    public List<SupportTicket> getAllTickets() {
        return supportTicketRepository.findAll();
    }

    public SupportTicket getTicketById(Long id) {
        return supportTicketRepository.findById(id).orElse(null);
    }

    public List<SupportTicket> getTicketsByEmployeeId(Long employeeId) {
        return supportTicketRepository.findByEmployeeId(employeeId);
    }

    public SupportTicket createTicket(SupportTicket ticket) {
        return supportTicketRepository.save(ticket);
    }

    public SupportTicket updateTicketStatus(Long ticketId, String status) {
        try {

            SupportTicket.TicketStatus ticketStatus = SupportTicket.TicketStatus.valueOf(status.toUpperCase());

            SupportTicket ticket = supportTicketRepository.findById(ticketId).orElse(null);
            if (ticket != null) {
                ticket.setStatus(ticketStatus);
                return supportTicketRepository.save(ticket);
            }
        } catch (IllegalArgumentException e) {
            
            throw new IllegalArgumentException("Invalid status value: " + status);
        }
        return null;
    }


    public boolean deleteTicket(Long id) {
        if (supportTicketRepository.existsById(id)) {
            supportTicketRepository.deleteById(id);
            return true;
        }
        return false;
    }
}



