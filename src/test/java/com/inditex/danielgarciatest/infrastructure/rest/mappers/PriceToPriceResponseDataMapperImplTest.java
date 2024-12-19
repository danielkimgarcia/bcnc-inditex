package com.inditex.danielgarciatest.infrastructure.rest.mappers;

import com.inditex.danielgarciatest.domain.Brand;
import com.inditex.danielgarciatest.domain.CurrencyIdentification;
import com.inditex.danielgarciatest.domain.Price;
import com.inditex.danielgarciatest.infrastructure.rest.responses.PriceResponseData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class PriceToPriceResponseDataMapperImplTest {

    private final PriceToPriceResponseDataMapper mapper = new PriceToPriceResponseDataMapperImpl();

    @Test
    @DisplayName("PriceToPriceResponseDataMapperImplTest -> Testing default scenario")
    void scenario1() {
        var price = Price.builder()
                .id(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priority(1)
                .priceTag(BigDecimal.TEN)
                .currencyIdentification(CurrencyIdentification.EUR)
                .brand(new Brand(1L, "ZARA"))
                .productId(1L)
                .build();

        //when
        PriceResponseData priceResponse = mapper.toPriceResponseData(price);

        //then
        Assertions.assertThat(priceResponse)
                .matches(p -> price.getStartDate().equals(p.startDate()))
                .matches(p -> price.getEndDate().equals(p.endDate()))
                .matches(p -> price.getPriceTag().toString().concat(" ").concat(priceResponse.currencyIdentification()).equals(p.getPrice()))
                .matches(p -> price.getPriority().equals(p.priority()))
                .matches(p -> price.getBrand().getId().equals(p.brandId()))
                .matches(p -> price.getProductId().equals(p.productId()));
    }

    @Test
    @DisplayName("PriceToPriceResponseDataMapperImplTest -> Testing nullable condition")
    void scenario2() {
        //given
        //when
        PriceResponseData priceResponseData = mapper.toPriceResponseData(null);

        //then
        Assertions.assertThat(priceResponseData).isNull();
    }

    @Test
    @DisplayName("PriceToPriceResponseDataMapperImplTest -> Testing when brand is null")
    void scenario3() {
        //given
        var price = Price.builder()
                .id(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priority(1)
                .priceTag(BigDecimal.TEN)
                .currencyIdentification(CurrencyIdentification.EUR)
                .brand(null)
                .productId(1L)
                .build();
        //when
        PriceResponseData priceResponse = mapper.toPriceResponseData(price);

        //then
        Assertions.assertThat(priceResponse)
                .matches(p -> price.getStartDate().equals(p.startDate()))
                .matches(p -> price.getEndDate().equals(p.endDate()))
                .matches(p -> price.getPriceTag().toString().concat(" ").concat(priceResponse.currencyIdentification()).equals(p.getPrice()))
                .matches(p -> price.getPriority().equals(p.priority()))
                .matches(p -> price.getProductId().equals(p.productId()));

        Assertions.assertThat(priceResponse.brandId()).isNull();
    }

    @Test
    @DisplayName("PriceToPriceResponseDataMapperImplTest -> Testing when product is null")
    void scenario4() {
        //given
        var price = Price.builder()
                .id(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priority(1)
                .priceTag(BigDecimal.TEN)
                .currencyIdentification(CurrencyIdentification.EUR)
                .brand(new Brand(1L, "ZARA"))
                .productId(null)
                .build();
        //when
        PriceResponseData priceResponse = mapper.toPriceResponseData(price);

        //then
        Assertions.assertThat(priceResponse)
                .matches(p -> price.getStartDate().equals(p.startDate()))
                .matches(p -> price.getEndDate().equals(p.endDate()))
                .matches(p -> price.getPriceTag().toString().concat(" ").concat(priceResponse.currencyIdentification()).equals(p.getPrice()))
                .matches(p -> price.getPriority().equals(p.priority()))
                .matches(p -> price.getBrand().getId().equals(p.brandId()));

        Assertions.assertThat(priceResponse.productId()).isNull();
    }

    @Test
    @DisplayName("PriceToPriceResponseDataMapperImplTest -> Testing when priceTag and currencyIdentification is null")
    void scenario5() {
        //given
        var price = Price.builder()
                .id(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priority(1)
                .priceTag(null)
                .currencyIdentification(null)
                .brand(new Brand(1L, "ZARA"))
                .productId(1L)
                .build();
        //when
        PriceResponseData priceResponse = mapper.toPriceResponseData(price);

        //then
        Assertions.assertThat(priceResponse)
                .matches(p -> price.getStartDate().equals(p.startDate()))
                .matches(p -> price.getEndDate().equals(p.endDate()))
                .matches(p -> price.getPriority().equals(p.priority()))
                .matches(p -> price.getBrand().getId().equals(p.brandId()))
                .matches(p -> price.getProductId().equals(p.productId()));

        Assertions.assertThat(priceResponse.getPrice()).isNull();
    }
}