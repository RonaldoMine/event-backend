package com.event.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String picture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id", nullable = false)
    private Enterprise enterprise;

    @Enumerated(EnumType.STRING)
    @Column(name="gender", nullable = false)
    private EnumGender gender;

}
