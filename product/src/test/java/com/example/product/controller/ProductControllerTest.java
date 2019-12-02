package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.html.Option;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ProductController.class)
@RunWith(SpringRunner.class)
@MockBean(ProductService.class)
public class ProductControllerTest{

    private static String GET_PRODUCT_URL = "/getProduct/{creditID}";
    private static String CREATE_PRODUCT_URL = "/createProduct";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private JacksonTester<Product> productJacksonTester;

    @Before
    public void init() {
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void shouldReturnHttp201WhenProductIsCreated() throws Exception {
        //given
        final Product product = new Product();
        product.setValue(1000);
        product.setName("Credit");
        product.setCreditID(UUID.randomUUID());
        doNothing().when(productService).saveProduct(any(Product.class));
        //when
        final MockHttpServletResponse response = mockMvc
                .perform(post(CREATE_PRODUCT_URL).content(productJacksonTester.write(product).getJson())
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();
        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo("");
        verify(productService).saveProduct(refEq(product));
    }

    @Test
    public void shouldReturnHttp200WhenProductIsFound() throws Exception {
        //given
        final Product product = new Product();
        product.setId(1L);
        product.setValue(1000);
        product.setName("Credit");
        product.setCreditID(UUID.randomUUID());
        given(productService.getProduct(any(UUID.class))).willReturn(product);
        //when
        final MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.get(GET_PRODUCT_URL, product.getCreditID())).andReturn().getResponse();
        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).contains(product.getName(),product.getCreditID().toString(), product.getValue().toString());
        verify(productService).getProduct(refEq(product.getCreditID()));
    }

}
