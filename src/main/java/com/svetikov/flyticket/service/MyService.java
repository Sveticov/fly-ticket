package com.svetikov.flyticket.service;

import com.svetikov.flyticket.model.Ticket;

import java.util.List;
import java.util.Set;

public interface MyService<T> {
    List<T> getAll();

    T findById(int id);

    T taskDiscountById();

    T getModule();

    void clearModule();

}
