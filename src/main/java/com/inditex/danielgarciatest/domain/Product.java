package com.inditex.danielgarciatest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;

    private String name;

    private Brand brand;
}