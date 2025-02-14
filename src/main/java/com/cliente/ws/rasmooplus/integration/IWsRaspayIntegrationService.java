package com.cliente.ws.rasmooplus.integration;

import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;

public interface IWsRaspayIntegrationService {

    CustomerDto createCustomer(CustomerDto request);
    OrderDto createOrder(OrderDto request);
    Boolean processPayment(PaymentDto request);
}
