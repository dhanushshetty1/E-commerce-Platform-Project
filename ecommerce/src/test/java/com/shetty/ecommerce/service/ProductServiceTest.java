package com.shetty.ecommerce.service;

import com.shetty.ecommerce.Entities.Product;
import com.shetty.ecommerce.dao.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product mockProduct;

    @BeforeEach
    void setUp() {
        mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("Laptop");
        mockProduct.setPrice(50000.0);
    }

    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(mockProduct));

        List<Product> products = productService.getAllProducts();

        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
    }

    @Test
    void testGetProductById_Found() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));

        Product product = productService.getProductById(1L);

        assertNotNull(product);
        assertEquals("Laptop", product.getName());
    }

    @Test
    void testGetProductById_NotFound() {
        when(productRepository.findById(2L)).thenReturn(Optional.empty());

        Product product = productService.getProductById(2L);

        assertNull(product);
    }

    @Test
    void testAddProduct() {
        when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        Product result = productService.addProduct(mockProduct);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        verify(productRepository).save(mockProduct);
    }

    @Test
    void testUpdateProduct() {
        Product updated = new Product();
        updated.setName("Updated Laptop");
        when(productRepository.save(any(Product.class))).thenReturn(updated);

        Product result = productService.updateProduct(1L, updated);

        assertNotNull(result);
        assertEquals("Updated Laptop", result.getName());
        assertEquals(1L, updated.getId());
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1L);

        verify(productRepository).deleteById(1L);
    }
}
