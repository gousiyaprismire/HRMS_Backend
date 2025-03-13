package com.hrms.serviceImplimentation.SelfService;
import com.hrms.model.SelfService.SupportTicket;
import com.hrms.repository.Selfservice.SupportTicketRepository;
import com.hrms.service.SelfService.SupportTicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketServiceImpl implements SupportTicketService {

    private final SupportTicketRepository repository;

    public SupportTicketServiceImpl(SupportTicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupportTicket submitTicket(SupportTicket ticket) {
        return repository.save(ticket);
    }

    @Override
    public List<SupportTicket> getAllTickets() {
        return repository.findAll();
    }

    @Override
    public SupportTicket getTicketById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SupportTicket> getTicketsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public SupportTicket updateTicket(Long id, SupportTicket updatedTicket) {
        Optional<SupportTicket> existingTicket = repository.findById(id);
        if (existingTicket.isPresent()) {
            SupportTicket ticket = existingTicket.get();
            ticket.setSubject(updatedTicket.getSubject());
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setStatus(updatedTicket.getStatus());
            return repository.save(ticket);
        }
        return null;
    }

    @Override
    public void deleteTicket(Long id) {
        repository.deleteById(id);
    }
}

