package com.inditex.danielgarciatest.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.danielgarciatest.application.responses.PriceResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequestMapping("/price")
@Validated
public interface PriceApi {

    @GetMapping
    @Operation(summary = "Price search resource", description = "Given a search date, brandId and productId, this resource will find the most priority price. The search date will be set between the start and the end date of the price registry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the price", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponseData.class))}),
            @ApiResponse(responseCode = "400", description = "Some validation error happened in your request", content = @Content),
            @ApiResponse(responseCode = "404", description = "The search date has not returned any register", content = @Content)})
    ResponseEntity<PriceResponseData> getPrice(
            @Schema(type = "string", name = "searchDate", example = "2020-06-14T16:00:00", description = "Search date to find a price between start and end date")
            @RequestParam("searchDate")
            @NotNull(message = "{price.searchDate.required}")
            @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
            LocalDateTime searchDate,

            @Schema(type = "string", name = "productId", example = "35455", description = "The product identification")
            @RequestParam("brandId")
            @NotNull(message = "{price.brandId.required}")
            @Min(value = 1, message = "{price.brandId.invalid}")
            Long brandId,

            @Schema(type = "string", name = "brandId", example = "1", description = "The brand identification")
            @RequestParam("productId")
            @NotNull(message = "{price.productId.required}")
            @Min(value = 1, message = "{price.productId.invalid}")
            Long productId
    );
}