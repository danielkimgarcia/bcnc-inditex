package com.inditex.danielgarciatest;

import com.inditex.danielgarciatest.application.mappers.PriceToPriceResponseDataMapper;
import com.inditex.danielgarciatest.application.mappers.PriceToPriceResponseDataMapperImpl;
import com.inditex.danielgarciatest.application.responses.PriceResponseData;
import com.inditex.danielgarciatest.domain.Brand;
import com.inditex.danielgarciatest.domain.CurrencyIdentification;
import com.inditex.danielgarciatest.domain.Price;
import com.inditex.danielgarciatest.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class PriceToPriceResponseDataMapperImplTest {

    private final PriceToPriceResponseDataMapper mapper = new PriceToPriceResponseDataMapperImpl();

    @Test
    @DisplayName("Testing PriceToPriceResponseDataMapper")
    void scenario1() {
        var price = Price.builder()
                .id(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priority(1)
                .priceTag(BigDecimal.TEN)
                .currencyIdentification(CurrencyIdentification.EUR)
                .brand(new Brand(1L, "ZARA"))
                .product(new Product(1L, "Product", new Brand(1L, "ZARA")))
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
                .matches(p -> price.getProduct().getId().equals(p.productId()));
    }

    @Test
    @DisplayName("Testing PriceToPriceResponseDataMapper - nullable condition")
    void scenario2() {
        //given
        //when
        PriceResponseData priceResponseData = mapper.toPriceResponseData(null);

        //then
        Assertions.assertThat(priceResponseData).isNull();
    }

    @Test
    @DisplayName("Testing PriceToPriceResponseDataMapper - when brand is null")
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
                .product(new Product(1L, "Product", new Brand(1L, "ZARA")))
                .build();
        //when
        PriceResponseData priceResponse = mapper.toPriceResponseData(price);

        //then
        Assertions.assertThat(priceResponse)
                .matches(p -> price.getStartDate().equals(p.startDate()))
                .matches(p -> price.getEndDate().equals(p.endDate()))
                .matches(p -> price.getPriceTag().toString().concat(" ").concat(priceResponse.currencyIdentification()).equals(p.getPrice()))
                .matches(p -> price.getPriority().equals(p.priority()))
                .matches(p -> price.getProduct().getId().equals(p.productId()));

        Assertions.assertThat(priceResponse.brandId()).isNull();
    }

    @Test
    @DisplayName("Testing PriceToPriceResponseDataMapper - when product is null")
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
                .product(null)
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
    @DisplayName("Testing PriceToPriceResponseDataMapper - when priceTag and currencyIdentification is null")
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
                .product(new Product(1L, "Product", new Brand(1L, "ZARA")))
                .build();
        //when
        PriceResponseData priceResponse = mapper.toPriceResponseData(price);

        //then
        Assertions.assertThat(priceResponse)
                .matches(p -> price.getStartDate().equals(p.startDate()))
                .matches(p -> price.getEndDate().equals(p.endDate()))
                .matches(p -> price.getPriority().equals(p.priority()))
                .matches(p -> price.getBrand().getId().equals(p.brandId()))
                .matches(p -> price.getProduct().getId().equals(p.productId()));

        Assertions.assertThat(priceResponse.getPrice()).isNull();
    }
}