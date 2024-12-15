package com.inditex.danielgarciatest.domain.ports.service;

import com.inditex.danielgarciatest.domain.Price;

import java.time.LocalDateTime;

public interface DomainPriceService {
    Price getPrice(LocalDateTime searchDate, Long brandId, Long productId);
}