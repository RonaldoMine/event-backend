package com.event.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String town;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer number_max_people;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id", nullable = false)
    private Enterprise enterprise;

    @Column(nullable = false)
    private Integer number_max_table;

    @Column(nullable = false)
    private Integer number_max_seat;

}
