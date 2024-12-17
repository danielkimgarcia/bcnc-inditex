package com.inditex.danielgarciatest;

import com.inditex.danielgarciatest.domain.CurrencyIdentification;
import com.inditex.danielgarciatest.domain.Price;
import com.inditex.danielgarciatest.infrastructure.repository.entities.BrandEntity;
import com.inditex.danielgarciatest.infrastructure.repository.entities.PriceEntity;
import com.inditex.danielgarciatest.infrastructure.repository.entities.ProductEntity;
import com.inditex.danielgarciatest.infrastructure.repository.mappers.PriceEntityToPriceMapper;
import com.inditex.danielgarciatest.infrastructure.repository.mappers.PriceEntityToPriceMapperImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class PriceEntityToPriceMapperImplTest {

    private final PriceEntityToPriceMapper mapper = new PriceEntityToPriceMapperImpl();

    @Test
    @DisplayName("Testing PriceEntityToPriceMapper")
    void scenario1() {
        var priceEntity = PriceEntity.builder()
                .id(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priority(1)
                .price(BigDecimal.TEN)
                .currencyIdentification(CurrencyIdentification.EUR)
                .brandEntity(new BrandEntity(1L, "ZARA"))
                .productEntity(new ProductEntity(1L, "Product", new BrandEntity(1L, "ZARA")))
                .build();

        //when
        Price price = mapper.toPrice(priceEntity);

        //then
        Assertions.assertThat(price)
                .matches(p -> priceEntity.getId().equals(p.getId()))
                .matches(p -> priceEntity.getStartDate().equals(p.getStartDate()))
                .matches(p -> priceEntity.getEndDate().equals(p.getEndDate()))
                .matches(p -> priceEntity.getPrice().equals(p.getPriceTag()))
                .matches(p -> priceEntity.getPriority().equals(p.getPriority()))
                .matches(p -> priceEntity.getCurrencyIdentification().equals(p.getCurrencyIdentification()))
                .matches(p -> priceEntity.getBrandEntity().getId().equals(p.getBrand().getId()))
                .matches(p -> priceEntity.getProductEntity().getId().equals(p.getProduct().getId()));
    }

    @Test
    @DisplayName("Testing PriceEntityToPriceMapper - nullable condition")
    void scenario2() {
        //given
        //when
        Price price = mapper.toPrice(null);

        //then
        Assertions.assertThat(price).isNull();
    }
}