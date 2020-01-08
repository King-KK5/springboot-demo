package com.emotte.springbootdemo.resttemplate;

import com.emotte.springbootdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:8082/user/all", HttpMethod.GET, entity, String.class).getBody();
    }
    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Account> entity = new HttpEntity<Account>(account,headers);

        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
    }
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") String id, @RequestBody Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Account> entity = new HttpEntity<Account>(account,headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Account> entity = new HttpEntity<Account>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }


}
