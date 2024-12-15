package com.inditex.danielgarciatest.infrastructure.repository.h2;

import com.inditex.danielgarciatest.application.exceptions.NotFoundException;
import com.inditex.danielgarciatest.domain.Price;
import com.inditex.danielgarciatest.domain.ports.repository.PriceRepository;
import com.inditex.danielgarciatest.infrastructure.repository.mappers.PriceEntityToPriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class H2DbPriceRepositoryAdapter implements PriceRepository {

    private final H2DbPriceRepository repository;
    private final PriceEntityToPriceMapper mapper;

    public Price getPrice(LocalDateTime searchDate, Long brandId, Long productId) {
        return repository.findFirstByBrandEntityIdAndProductEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, searchDate, searchDate)
                .map(mapper::toPrice)
                .orElseThrow(() -> new NotFoundException("The search date has not returned any register"));
    }
}