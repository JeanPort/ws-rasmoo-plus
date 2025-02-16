package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PaymentProcessRequest;

public interface IUserPaymentInfoService {

    Boolean processPayment(PaymentProcessRequest request);
}
