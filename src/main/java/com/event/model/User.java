package com.event.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "setting_id", referencedColumnName = "id")
    private Setting setting;


}
