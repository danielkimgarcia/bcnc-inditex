package com.inditex.danielgarciatest.application.mappers;

import com.inditex.danielgarciatest.application.responses.PriceResponseData;
import com.inditex.danielgarciatest.domain.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * This interface provides a mapper implementation to convert a price entity offering a
 * custom response possibility for the price lookup feature without necessary changes
 * to the domain class
 */

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PriceToPriceResponseDataMapper {
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "price", source = "priceTag")
    PriceResponseData toPriceResponseData(Price price);
}