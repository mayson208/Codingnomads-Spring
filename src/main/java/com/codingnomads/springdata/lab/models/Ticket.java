package com.codingnomads.springdata.lab.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String passengerName;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Area boardingArea;

    public Ticket(String passengerName, Route route, Area boardingArea) {
        this.passengerName = passengerName;
        this.route = route;
        this.boardingArea = boardingArea;
    }
}