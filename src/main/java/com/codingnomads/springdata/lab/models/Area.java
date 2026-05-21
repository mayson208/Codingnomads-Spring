/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "areas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    public Area(String code) {
        this.code = code;
    }
}