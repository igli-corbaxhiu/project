package com.lhind.project.service;

import com.lhind.project.model.Flight;
import com.lhind.project.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImp implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImp(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public Flight getById(int id) {
        return flightRepository.getById(id);
    }

    @Override
    public void delete(Flight flight) {
        flightRepository.delete(flight);
    }
}
