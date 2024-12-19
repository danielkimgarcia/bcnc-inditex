package com.inditex.danielgarciatest.application.usercases;

import com.inditex.danielgarciatest.application.usecases.DomainPriceServiceImpl;
import com.inditex.danielgarciatest.domain.Brand;
import com.inditex.danielgarciatest.domain.CurrencyIdentification;
import com.inditex.danielgarciatest.domain.Price;
import com.inditex.danielgarciatest.domain.exceptions.NotFoundException;
import com.inditex.danielgarciatest.domain.ports.repository.PriceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class DomainPriceServiceIT {

    @InjectMocks
    private DomainPriceServiceImpl service;

    @Mock
    private PriceRepository repository;

    @Test
    @DisplayName("DomainPriceServiceIT -> Testing the default scenario")
    void scenario1() {
        var price = Price.builder()
                .id(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priceTag(BigDecimal.TEN)
                .priority(1)
                .currencyIdentification(CurrencyIdentification.EUR)
                .brand(new Brand(1L, "ZARA"))
                .productId(1L)
                .build();

        given(repository.getPrice(any(LocalDateTime.class), anyLong(), anyLong())).willReturn(price);

        //when
        Price priceReturned = service.getPrice(LocalDateTime.now(), 1L, 1L);

        //then
        Assertions.assertThat(priceReturned)
                .matches(p -> price.getId().equals(p.getId()))
                .matches(p -> price.getStartDate().equals(p.getStartDate()))
                .matches(p -> price.getEndDate().equals(p.getEndDate()))
                .matches(p -> price.getPriceTag().equals(p.getPriceTag()))
                .matches(p -> price.getPriority().equals(p.getPriority()))
                .matches(p -> price.getCurrencyIdentification().equals(p.getCurrencyIdentification()))
                .matches(p -> price.getBrand().getId().equals(p.getBrand().getId()))
                .matches(p -> price.getProductId().equals(p.getProductId()));

    }

    @Test
    @DisplayName("DomainPriceServiceIT -> Testing notFound exception scenario")
    void scenario2() {
        given(repository.getPrice(any(LocalDateTime.class), anyLong(), anyLong())).willThrow(new NotFoundException("The search date has not returned any register"));

        try {
            when(service.getPrice(LocalDateTime.now(), 1L, 1L));
        } catch (NotFoundException expected) {
            //then
            Assertions.assertThat(expected.getMessage())
                    .matches("The search date has not returned any register");
        }
    }
}