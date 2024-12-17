package com.inditex.danielgarciatest.infrastructure.configurations;

import com.inditex.danielgarciatest.InditexApplication;
import com.inditex.danielgarciatest.domain.ports.repository.PriceRepository;
import com.inditex.danielgarciatest.domain.ports.service.DomainPriceService;
import com.inditex.danielgarciatest.domain.usecases.DomainPriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = InditexApplication.class)
public class BeanConfiguration {

    /**
     * This method guarantee only domain dependencies to the use case class
     * maintaining the hexagonal architecture pattern
     *
     * @param priceRepository
     * @return
     */
    @Bean
    DomainPriceService priceService(final PriceRepository priceRepository) {
        return new DomainPriceServiceImpl(priceRepository);
    }
}