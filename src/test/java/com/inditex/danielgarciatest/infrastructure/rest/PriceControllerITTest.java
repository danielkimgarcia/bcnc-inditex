package com.inditex.danielgarciatest.infrastructure.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerITTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("PriceControllerIT -> petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void scenario1() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-14T10:00:00")
                        .param("brandId", "1")
                        .param("productId", "35455"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                          "productId": 35455,
                          "brandId": 1,
                          "priority": 0,
                          "startDate": "2020-06-14T00:00:00",
                          "endDate": "2020-12-31T23:59:59",
                          "price": "35.50 EUR"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void scenario2() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-14T16:00:00")
                        .param("brandId", "1")
                        .param("productId", "35455"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                          "productId": 35455,
                          "brandId": 1,
                          "priority": 1,
                          "startDate": "2020-06-14T15:00:00",
                          "endDate": "2020-06-14T18:30:00",
                          "price": "25.45 EUR"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void scenario3() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-14T21:00:00")
                        .param("brandId", "1")
                        .param("productId", "35455"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                          "productId": 35455,
                          "brandId": 1,
                          "priority": 0,
                          "startDate": "2020-06-14T00:00:00",
                          "endDate": "2020-12-31T23:59:59",
                          "price": "35.50 EUR"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void scenario4() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-15T10:00:00")
                        .param("brandId", "1")
                        .param("productId", "35455"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                          "productId": 35455,
                          "brandId": 1,
                          "priority": 1,
                          "startDate": "2020-06-15T00:00:00",
                          "endDate": "2020-06-15T11:00:00",
                          "price": "30.50 EUR"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void scenario5() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-21T10:00:00")
                        .param("brandId", "1")
                        .param("productId", "35455"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                          "productId": 35455,
                          "brandId": 1,
                          "priority": 1,
                          "startDate": "2020-06-15T16:00:00",
                          "endDate": "2020-12-31T23:59:59",
                          "price": "38.95 EUR"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with all parameters but without any return")
    void scenario6() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2000-06-15T10:00:00")
                        .param("brandId", "1")
                        .param("productId", "35455"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "The search date has not returned any register"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search without any parameters")
    void scenario7() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "Required request parameter 'searchDate' for method parameter type LocalDateTime is not present"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with searchDate only")
    void scenario8() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-15T10:00:00")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "Required request parameter 'brandId' for method parameter type Long is not present"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with brandId only")
    void scenario9() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("brandId", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "Required request parameter 'searchDate' for method parameter type LocalDateTime is not present"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with productId only")
    void scenario10() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("productId", "35455")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "Required request parameter 'searchDate' for method parameter type LocalDateTime is not present"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with searchDate and brandId")
    void scenario11() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-15T10:00:00")
                        .param("brandId", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "Required request parameter 'productId' for method parameter type Long is not present"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with searchDate and productId")
    void scenario12() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "Required request parameter 'brandId' for method parameter type Long is not present"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with productId and brandId")
    void scenario13() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        	"message": "Required request parameter 'searchDate' for method parameter type LocalDateTime is not present"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with invalid brandId")
    void scenario14() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-15T10:00:00")
                        .param("brandId", "0")
                        .param("productId", "35455")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "message": "getPrice.brandId: The brand ID needs to be greater than 0"
                        }
                        """));
    }

    @Test
    @DisplayName("PriceControllerIT -> Search with invalid productId")
    void scenario15() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/price")
                        .param("searchDate", "2020-06-15T10:00:00")
                        .param("brandId", "1")
                        .param("productId", "0")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "message": "getPrice.productId: The product ID needs to be greater than 0"
                        }
                        """));
    }
}