package com.example.product.services;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void shouldCreateProduct(){
        //given
        final Product product = new Product();
        product.setCreditNumber(UUID.randomUUID());
        product.setName("example");
        product.setValue(1000);
        given(productRepository.save(product)).will(InvocationOnMock::getMock);

        //when
        productService.saveProduct(product);

        //then
        verify(productRepository).save(product);
    }

    @Test
    public void shouldNotCreateProductWhenUUIDIsNotSet(){

    }
}
