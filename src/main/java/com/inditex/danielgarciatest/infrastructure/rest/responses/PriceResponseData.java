package com.inditex.danielgarciatest.infrastructure.rest.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * Java record class to represent a search a price response that is based on date interval and priority
 * of a determined branded product
 *
 * @param productId
 * @param brandId
 * @param priority
 * @param startDate
 * @param endDate
 * @param price
 */
public record PriceResponseData(
        @Schema(name = "productId", example = "35455", description = "The product identification")
        Long productId,
        @Schema(name = "brandId", example = "1", description = "The brand identification")
        Long brandId,
        @Schema(name = "priority", example = "2", description = "Priority checked to set the current price for the searched date")
        Integer priority,
        @Schema(name = "startDate", example = "2020-06-14T16:00:00", description = "Start date of the period searched")
        LocalDateTime startDate,
        @Schema(name = "endDate", example = "2020-06-14T16:00:00", description = "End date of the period searched")
        LocalDateTime endDate,
        @Schema(name = "price", example = "25.45 EUR", description = "Priority price applied on the searched date")
        String price,
        @Schema(name = "currencyIdentification", example = "EUR", description = "Currency identification for the price")
        @JsonIgnore
        String currencyIdentification
) {

    /**
     * Custom format for price attribute
     */
    public String getPrice() {

        if(this.price == null){
            return null;
        }

        return this.price.concat(" ").concat(this.currencyIdentification);

    }
}