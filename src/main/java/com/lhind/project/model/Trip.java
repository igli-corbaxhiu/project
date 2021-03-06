package com.lhind.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_id")
    private int id;

    @NotBlank(message = "Select one of the options!")
    private String tripReason;

    @NotBlank(message = "Please enter your trip description!")
    @Size(max = 100)
    private String tripDescription;

    @NotBlank(message = "\"From place\" field must not be blank!")
    private String fromPlace;

    @NotBlank(message = "\"To place\" field must not be blank!")
    private String toPlace;

    private java.sql.Date departureDate;

    private java.sql.Date arrivalDate;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.REMOVE)
    private Set<Flight> flights;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTripReason() {
        return tripReason;
    }

    public void setTripReason(String tripReason) {
        this.tripReason = tripReason;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripReason='" + tripReason + '\'' +
                ", tripDescription='" + tripDescription + '\'' +
                ", fromPlace='" + fromPlace + '\'' +
                ", toPlace='" + toPlace + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", flights=" + flights +
                ", user=" + user +
                '}';
    }
}
