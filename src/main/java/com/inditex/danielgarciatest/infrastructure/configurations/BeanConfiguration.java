package com.inditex.danielgarciatest.infrastructure.configurations;

import com.inditex.danielgarciatest.DanielGarciaTestApplication;
import com.inditex.danielgarciatest.domain.usecases.DomainPriceServiceImpl;
import com.inditex.danielgarciatest.domain.ports.repository.PriceRepository;
import com.inditex.danielgarciatest.domain.ports.service.DomainPriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DanielGarciaTestApplication.class)
public class BeanConfiguration {

    @Bean
    DomainPriceService priceService(final PriceRepository priceRepository) {
        return new DomainPriceServiceImpl(priceRepository);
    }
}