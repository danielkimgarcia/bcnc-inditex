package com.inditex.danielgarciatest.domain.usecases;

import com.inditex.danielgarciatest.domain.Price;
import com.inditex.danielgarciatest.domain.ports.repository.PriceRepository;
import com.inditex.danielgarciatest.domain.ports.service.DomainPriceService;

import java.time.LocalDateTime;

public class DomainPriceServiceImpl implements DomainPriceService {

    private final PriceRepository repository;

    public DomainPriceServiceImpl(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Price getPrice(LocalDateTime searchDate, Long brandId, Long productId) {
        return repository.getPrice(searchDate, brandId, productId);
    }
}