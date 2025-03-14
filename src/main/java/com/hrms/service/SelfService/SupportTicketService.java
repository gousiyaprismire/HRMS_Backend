package com.hrms.service.SelfService;


import com.hrms.model.SelfService.SupportTicket;

import java.util.List;

public interface SupportTicketService {
    SupportTicket submitTicket(SupportTicket ticket);
    List<SupportTicket> getAllTickets();
    SupportTicket getTicketById(Long id);
    List<SupportTicket> getTicketsByUserId(Long userId);
    SupportTicket updateTicket(Long id, SupportTicket updatedTicket);
    void deleteTicket(Long id);
}


