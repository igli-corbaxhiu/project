package com.lhind.project.service;

import com.lhind.project.model.Trip;
import com.lhind.project.repository.TripRepository;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImp implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImp(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void save(Trip trip) {
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
