package com.inditex.danielgarciatest.infrastructure.repository.mappers;

import com.inditex.danielgarciatest.domain.Brand;
import com.inditex.danielgarciatest.domain.Price;
import com.inditex.danielgarciatest.domain.Product;
import com.inditex.danielgarciatest.infrastructure.repository.entities.BrandEntity;
import com.inditex.danielgarciatest.infrastructure.repository.entities.PriceEntity;
import com.inditex.danielgarciatest.infrastructure.repository.entities.ProductEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PriceEntityToPriceMapper {
    @Mapping(target = "product", source = "productEntity", qualifiedByName = "entityProductToProduct")
    @Mapping(target = "brand", source = "brandEntity", qualifiedByName = "entityBrandToBrand")
    Price toPrice(PriceEntity priceEntity);

    @Named("entityProductToProduct")
    default Product entityProductToProduct(ProductEntity productEntity) {
        return new Product(productEntity.getId(), productEntity.getName(), new Brand(productEntity.getBrand().getId(), productEntity.getBrand().getName()));
    }

    @Named("entityBrandToBrand")
    default Brand entityBrandToBrand(BrandEntity brandEntity) {
        return new Brand(brandEntity.getId(), brandEntity.getName());
    }
}