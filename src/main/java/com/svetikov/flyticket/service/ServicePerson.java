package com.svetikov.flyticket.service;

import com.svetikov.flyticket.model.Baggage;
import com.svetikov.flyticket.model.Destination;
import com.svetikov.flyticket.model.Person;
import com.svetikov.flyticket.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ServicePerson implements ServPerson {
    final ServiceTicket serviceTicket;
    private Person person;
    private Ticket ticket;
    private Baggage baggage;
    private Random rnd;
    private Destination destination;

    public ServicePerson(ServiceTicket serviceTicket) {
        this.serviceTicket = serviceTicket;

    }

    public void createPerson(Ticket ticketGlobal) {
        ticket = ticketGlobal;

        rnd = new Random();
        destination = serviceTicket.findById(rnd.nextInt(serviceTicket.getAll().size() - 1)).getDestination();
        baggage = new Baggage(rnd.nextInt(5), rnd.nextInt(100) + 10, destination);

        System.out.println(ticket.getDestination());
        System.out.println(baggage.getDestination());

        person = new Person(
                rnd.nextInt(5),
                "Tom",
                ticket,
                baggage);
    }

    public boolean checkIn() {
        createPerson(serviceTicket.getModule());
        serviceTicket.clearModule();
        return compareTo(ticket, baggage);

    }

    private boolean compareTo(Ticket ticket, Baggage baggage) {
        Destination d1 = ticket.getDestination();
        Destination d2 = baggage.getDestination();

        System.out.println(d1.getTo() == d2.getTo());
        System.out.println(d2.getFrom() == d1.getFrom());

        if (d1.getFrom() == d2.getFrom() && d1.getTo() == d2.getTo())
            return true;

        return false;
    }

    public Person getPerson(){
        return person;
    }


}
