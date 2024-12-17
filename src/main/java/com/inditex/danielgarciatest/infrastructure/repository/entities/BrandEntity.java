package com.inditex.danielgarciatest.infrastructure.repository.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "brands")
@Entity(name = "BrandEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}