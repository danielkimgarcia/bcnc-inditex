package com.inditex.danielgarciatest.infrastructure.rest;

import com.inditex.danielgarciatest.infrastructure.rest.mappers.PriceToPriceResponseDataMapper;
import com.inditex.danielgarciatest.infrastructure.rest.responses.PriceResponseData;
import com.inditex.danielgarciatest.domain.ports.service.DomainPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PriceController implements PriceApi {

    private final DomainPriceService service;
    private final PriceToPriceResponseDataMapper mapper;

    @Override
    public ResponseEntity<PriceResponseData> getPrice(LocalDateTime searchDate, Long brandId, Long productId) {
        log.info("New price search requested: searchDate: {}, brandId: {}, productId: {} ", searchDate, brandId, productId);

        return ResponseEntity.ok().body(mapper.toPriceResponseData(service.getPrice(searchDate, brandId, productId)));
    }
}