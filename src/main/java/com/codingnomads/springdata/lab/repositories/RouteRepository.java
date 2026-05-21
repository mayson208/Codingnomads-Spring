package com.codingnomads.springdata.lab.repositories;

import com.codingnomads.springdata.lab.models.Route;
import com.codingnomads.springdata.lab.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByOrigin(Area origin);

    List<Route> findByDestination(Area destination);

    Route findByCode(String code);
}