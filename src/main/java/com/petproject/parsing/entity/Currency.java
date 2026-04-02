package com.petproject.parsing.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "currency")
@Data
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long r030;
    private String cc;
    private String txt;
    private Double rate;
    private LocalDate exchangeDate;
}
