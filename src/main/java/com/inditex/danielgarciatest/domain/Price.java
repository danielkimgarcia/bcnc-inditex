package com.inditex.danielgarciatest.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Price {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private BigDecimal price;
    private CurrencyIdentification currencyIdentification;
    private Brand brand;
    private Product product;
}
