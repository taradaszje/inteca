package com.example.product.services;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

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
        product.setName("example");
        product.setValue(1000);
        given(productRepository.save(product)).willReturn(product);

        //when
        productService.saveProduct(product);

        //then
        verify(productRepository).save(product);
    }

    @Test
    public void shouldFindProduct(){
        //given
        final Product product = new Product();
        final UUID uuid = UUID.randomUUID();
        product.setCreditID(uuid);
        product.setName("credit");
        given(productRepository.save(product)).will(invocationOnMock -> invocationOnMock.getArgument(0));
        given(productRepository.findByCreditID(uuid)).willReturn(Optional.of(product));
        //when
        final Product found = productService.getProduct(uuid);
        //then
        verify(productRepository).findByCreditID(uuid);
        assertThat(found).isEqualTo(product);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenProductWithThisUUIDNotExists(){
        //given
        final Product product = new Product();
        final UUID uuid = UUID.randomUUID();
        product.setCreditID(uuid);
        product.setName("credit");
        given(productRepository.save(product)).will(invocationOnMock -> invocationOnMock.getArgument(0));
        given(productRepository.findByCreditID(UUID.randomUUID())).willReturn(Optional.empty());
        //when
        final ThrowableAssert.ThrowingCallable invocation = () -> productService.getProduct(uuid);
        //then
        verify(productRepository,times(0)).findByCreditID(uuid);
        assertThatThrownBy(invocation).isInstanceOf(EntityNotFoundException.class);
    }
}
