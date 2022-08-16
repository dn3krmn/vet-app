package com.dk.vetapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners", schema = "vetapp")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;
    @Column(nullable = false)
    private String ownerName;
    @Column(nullable = false)
    private String ownerSurname;
    @Lob
    private String address;
    private String phoneNumber;
    private String email;
}
