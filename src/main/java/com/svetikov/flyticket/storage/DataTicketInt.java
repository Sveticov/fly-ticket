package com.svetikov.flyticket.storage;

import com.svetikov.flyticket.model.Ticket;

import java.util.List;

public interface DataTicketInt {
    public void addTicket();
    public void printList();
    public List<Ticket> listTicket();
}
