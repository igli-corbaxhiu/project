package com.lhind.project.service;

import com.lhind.project.model.Trip;

import java.util.List;

public interface TripService {

    void save(Trip trip);
    Trip getById(int id);
    void delete(Trip trip);
}
