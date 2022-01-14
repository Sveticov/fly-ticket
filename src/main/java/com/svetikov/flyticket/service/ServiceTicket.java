package com.svetikov.flyticket.service;

import com.svetikov.flyticket.model.DiscountCard;
import com.svetikov.flyticket.model.MakeDiscount;
import com.svetikov.flyticket.model.Ticket;
import com.svetikov.flyticket.storage.DataTicketInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ServiceTicket implements MyService<Ticket>, OtherService {
    private final DataTicketInt repository;

    public ServiceTicket(DataTicketInt repository) {
        this.repository = repository;
    }

    private Ticket ticket;

    @Bean
    private MakeDiscount makeDiscount() {
        return new DiscountCard();
    }

    @Override
    public List<Ticket> getAll() {

        return repository.listTicket();
    }

    @Override
    public Ticket findById(int id) {
        ticket = repository.listTicket().stream()
                .filter(it -> it.getIdTicket() == id)
                .findFirst()
                .get();
        return ticket;
    }

    @Override
    public Ticket taskDiscountById() {


        double disc = makeDiscount().makeDiscount();
        double costs = getModule().getCosts() * disc;
        ticket.setCosts(ticket.getCosts() - costs);
        return ticket;


    }
    @Override
    public Ticket getModule() {
        if (ticket != null)
            return ticket;
        else throw new NoSuchElementException();
    }

    @Override
    public void clearModule() {
       ticket =null;
    }

    @Override
    public Set<String> allCountry() {
        return repository.listTicket().stream()
                .map(it -> it.getDestination().getFrom())
                .sorted()
                .collect(Collectors.toSet());
    }
}
