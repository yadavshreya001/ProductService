package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testGetProductByIdPositive() {

    }

    @Test
    void testGetProductByIdNegative() {

    }

    @Test
    void testGetProductByIdThrowsException() {

    }

    @Test
    void testGetAllProducts() {
//        List<Product> expectedProducts = new ArrayList<>();
//
//        Product p1 = new Product();
//        p1.setTitle("iphone 15");
//        p1.setPrice(100000.0);
//
//        Product p2 = new Product();
//        p1.setTitle("iphone 16");
//        p1.setPrice(110000.0);
//
//        Product p3 = new Product();
//        p1.setTitle("iphone 17");
//        p1.setPrice(120000.0);
//
//        expectedProducts.add(p1);
//        expectedProducts.add(p2);
//        expectedProducts.add(p3);
//
//        when(productService.getAllProducts())
//                .thenReturn(expectedProducts);
//
//        List<Product> actualProducts = productController.getAllProducts();
//
//        assertEquals(expectedProducts.size(), actualProducts.size());
//
////        assertEquals(expectedProducts, actualProducts);
//
//        for (int i = 0; i < expectedProducts.size(); i++) {
//            assertEquals(
//                    expectedProducts.get(i), //@123
//                    actualProducts.get(i) // @123
//            );
//        }
    }
}