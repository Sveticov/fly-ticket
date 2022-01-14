package com.svetikov.flyticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private int idTicket;
    private double costs;
    private Destination destination;
}
