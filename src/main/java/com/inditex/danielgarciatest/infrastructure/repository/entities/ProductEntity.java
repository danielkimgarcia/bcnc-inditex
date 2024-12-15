package com.inditex.danielgarciatest.infrastructure.repository.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity(name = "ProductEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brand;
}