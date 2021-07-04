package com.lhind.project.service;

import com.lhind.project.model.Flight;
import com.lhind.project.model.Trip;
import com.lhind.project.repository.FlightRepository;
import com.lhind.project.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class TripServiceImp implements TripService {

    private final TripRepository tripRepository;
    private final FlightRepository flightRepository;

    public TripServiceImp(TripRepository tripRepository, FlightRepository flightRepository) {
        this.tripRepository = tripRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public void save(Trip trip) {
        Flight tripFlight = flightRepository.findById(trip.getId());
        trip.setFlights(new HashSet<>(Arrays.asList(tripFlight)));
        tripRepository.save(trip);
    }

    @Override
    public Trip getById(int id) {
        return tripRepository.getById(id);
    }

    @Override
    public void delete(Trip trip) {
        tripRepository.delete(trip);
    }

}
