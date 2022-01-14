package com.svetikov.flyticket.controller;

import com.svetikov.flyticket.model.Person;
import com.svetikov.flyticket.model.Ticket;
import com.svetikov.flyticket.service.MyService;
import com.svetikov.flyticket.service.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/app/ticket")
public class TicketController {
    private final ServicePerson servicePerson;
    private final MyService<Ticket> service;

    public TicketController(MyService<Ticket> service, ServicePerson servicePerson) {
        this.service = service;
        this.servicePerson = servicePerson;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> allTicket(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketId(@PathVariable int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/discount/{id}")
    public ResponseEntity<Ticket> discountTicketId() {
        return ResponseEntity.ok(service.taskDiscountById());
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkIn(){
        return ResponseEntity.ok(servicePerson.checkIn());
    }

    @GetMapping("/person")
    public ResponseEntity<Person> getPerson(){
        return ResponseEntity.ok(servicePerson.getPerson());
    }

}
