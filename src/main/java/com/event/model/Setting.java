package com.event.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "settings")
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
