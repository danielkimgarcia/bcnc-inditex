package com.inditex.danielgarciatest.domain.ports.repository;

import com.inditex.danielgarciatest.domain.Price;

import java.time.LocalDateTime;

public interface PriceRepository {
    Price getPrice(LocalDateTime searchDate, Long brandId, Long productId);
}
