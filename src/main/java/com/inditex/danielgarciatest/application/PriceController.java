package com.inditex.danielgarciatest.application;

import com.inditex.danielgarciatest.application.mappers.PriceToPriceResponseDataMapper;
import com.inditex.danielgarciatest.application.responses.PriceResponseData;
import com.inditex.danielgarciatest.domain.ports.service.DomainPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PriceController implements PriceControllerApi {

    private final DomainPriceService service;
    private final PriceToPriceResponseDataMapper mapper;

    public ResponseEntity<PriceResponseData> getPrice(String searchDate, Long brandId, Long productId) {
        log.info("New search requested: searchDate: {}, brandId: {}, productId{} ", searchDate, brandId, productId);

        return ResponseEntity.ok().body(mapper.toPriceResponseData(service.getPrice(LocalDateTime.parse(searchDate), brandId, productId)));
    }
}