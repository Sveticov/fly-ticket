package com.svetikov.flyticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    private String from;
    private String to;
    private boolean exists;
}
