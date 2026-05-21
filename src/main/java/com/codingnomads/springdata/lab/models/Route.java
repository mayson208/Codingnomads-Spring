/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "routes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "origin_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_origin_area_id"))
    private Area origin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "destination_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_destination_area_id"))
    private Area destination;

    public Route(Area origin, Area destination) {
        this.origin = origin;
        this.destination = destination;

        if (origin != null && destination != null) {
            this.code = origin.getCode() + "-" + destination.getCode();
        }
    }

    public void setOrigin(Area origin) {
        this.origin = origin;
        generateCode();
    }

    public void setDestination(Area destination) {
        this.destination = destination;
        generateCode();
    }

    private void generateCode() {
        if (origin != null && destination != null) {
            this.code = origin.getCode() + "-" + destination.getCode();
        }
    }
}