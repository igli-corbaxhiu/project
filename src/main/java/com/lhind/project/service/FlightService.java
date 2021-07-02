package com.lhind.project.service;

import com.lhind.project.model.Flight;

public interface FlightService {

    void save(Flight flight);
    Flight getById(int id);
}
