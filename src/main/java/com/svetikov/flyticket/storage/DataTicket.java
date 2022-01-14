package com.svetikov.flyticket.storage;

import com.svetikov.flyticket.model.Destination;
import com.svetikov.flyticket.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataTicket implements DataTicketInt{

    private List<Ticket> ticketList = new ArrayList();
    private Random rnd = new Random();
    private Random rndExists = new Random();
    private double costs = 0.0;
    private boolean exists = false;
    private String countryFrom ="";
    private String countryTo ="";
    private int maxTicket=10;
    private List<String> listCountry=new ArrayList();
@Override
    public void addTicket() {
        listCountry.add("GB");
        listCountry.add("UA");
        listCountry.add("AU");
        listCountry.add("CAN");
        listCountry.add("FL");
        listCountry.add("USA");
        for (int i = 0; i < maxTicket; i++) {
            costs = rnd.nextDouble() * 100.0;
            costs=Math.floor(costs);
            exists = rnd.nextBoolean();
            countryTo =listCountry.get(rnd.nextInt(listCountry.size()));
            countryFrom =listCountry.get(rnd.nextInt(listCountry.size()));

            ticketList.add(new Ticket(i + 1, costs, new Destination(countryTo, countryFrom, exists)));
        }

    }
    @Override
    public void printList(){
        ticketList.stream()
                .forEach(s-> System.out.println(s));
    }

    @Override
    public List<Ticket> listTicket() {
        return ticketList;
    }

}
