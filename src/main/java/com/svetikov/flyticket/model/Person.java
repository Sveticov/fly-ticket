package com.svetikov.flyticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private  int id;
    private String name;
    private Ticket ticket;
    private Baggage baggage;
}
