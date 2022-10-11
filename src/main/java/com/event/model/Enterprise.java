package com.event.model;

import lombok.Data;

import javax.persistence.*;

/**
 * To manage multiples enterprises
 */
@Data
@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
