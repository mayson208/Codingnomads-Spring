package com.codingnomads.springdata.lab;

import com.codingnomads.springdata.lab.models.*;
import com.codingnomads.springdata.lab.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringDataLab implements CommandLineRunner {

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void run(String... args) {

        if (areaRepository.count() == 0) {
            areaRepository.save(new Area("X"));
            areaRepository.save(new Area("Y"));
            areaRepository.save(new Area("Z"));
            areaRepository.save(new Area("W"));
        }

        if (routeRepository.count() == 0) {

            Area y = areaRepository.findByCode("Y");
            Area z = areaRepository.findByCode("Z");
            Area x = areaRepository.findByCode("X");

            routeRepository.save(new Route(y, z));
            routeRepository.save(new Route(z, x));
            routeRepository.save(new Route(x, y));
        }

        if (ticketRepository.count() == 0) {

            Route yz = routeRepository.findByCode("Y-Z");

            ticketRepository.save(new Ticket("Mason", yz, yz.getOrigin()));
            ticketRepository.save(new Ticket("Rachel", yz, yz.getOrigin()));
        }


        System.out.println("Route Y-Z:");
        System.out.println(routeRepository.findByCode("Y-Z"));

        System.out.println("Routes starting at Y:");
        System.out.println(routeRepository.findByOrigin(
                areaRepository.findByCode("Y")
        ));

        System.out.println("Routes ending at Z:");
        System.out.println(routeRepository.findByDestination(
                areaRepository.findByCode("Z")
        ));

        System.out.println("Tickets for Y-Z:");
        System.out.println(ticketRepository.findByRoute_Code("Y-Z"));
    }
}