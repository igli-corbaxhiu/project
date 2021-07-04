package com.lhind.project.repository;

import com.lhind.project.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}
