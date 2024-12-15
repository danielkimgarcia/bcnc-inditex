package com.inditex.danielgarciatest.infrastructure.repository.h2;

import com.inditex.danielgarciatest.infrastructure.repository.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface H2DbPriceRepository extends JpaRepository<PriceEntity, Long> {
    Optional<PriceEntity> findFirstByBrandEntityIdAndProductEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}