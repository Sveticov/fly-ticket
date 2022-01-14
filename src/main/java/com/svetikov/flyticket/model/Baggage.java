package com.svetikov.flyticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Baggage {
    private int id;
    private int weight;
    private Destination destination;
}
