package com.cliente.ws.rasmooplus.integration;

import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Component
public class WsRaspayIntegrationImpl implements IWsRaspayIntegrationService{

    @Value("${webservice.raspay.host}")
    private String hostValue;

    @Value("$${RASPAY_CUSTUMER:/v1/customer}")
    private String customerValue;

    @Value("$${RASPAY_CUSTUMER:/v1/order}")
    private String orderValue;

    @Value("$${RASPAY_CUSTUMER:/v1/payment}")
    private String paymentValue;

    private final RestTemplate restTemplate;

    public WsRaspayIntegrationImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto request) {
        try{
            var headers = getHeaders();
            var httpEntity = new HttpEntity<>(request, headers);
            var responseEntity = restTemplate.exchange(hostValue + customerValue, HttpMethod.POST, httpEntity, CustomerDto.class);
            return responseEntity.getBody();
        }catch (Exception e) {
            throw e;
        }
    }



    @Override
    public OrderDto createOrder(OrderDto request) {
        try {
            var heades = getHeaders();
            var order = new HttpEntity<>(request, heades);
            var response = restTemplate.exchange(hostValue + orderValue, HttpMethod.POST, order, OrderDto.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public Boolean processPayment(PaymentDto request) {
        try {
            var headers = getHeaders();
            var payment = new HttpEntity<>(request, headers);
            var response = restTemplate.exchange(hostValue + paymentValue, HttpMethod.POST, payment, Boolean.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credentials = "rasmooplus:r@sm00";
        String base64 = Base64.getEncoder().encodeToString(credentials.getBytes());
        headers.add("Authorization", "Basic " + base64);
        return headers;
    }
}
