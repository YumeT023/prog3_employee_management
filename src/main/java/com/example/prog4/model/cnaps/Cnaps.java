package com.example.prog4.model.cnaps;


import jakarta.persistence.*;

@Entity
public class Cnaps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id ;

    private String number;
}
