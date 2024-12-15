package com.inditex.danielgarciatest.application.mappers;

import com.inditex.danielgarciatest.application.responses.PriceResponseData;
import com.inditex.danielgarciatest.domain.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PriceToPriceResponseDataMapper {
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "brandId", source = "brand.id")
    PriceResponseData toPriceResponseData(Price price);
}
