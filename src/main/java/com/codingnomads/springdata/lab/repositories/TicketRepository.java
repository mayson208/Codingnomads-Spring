package com.codingnomads.springdata.lab.repositories;

import com.codingnomads.springdata.lab.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByRoute_Code(String code);
}